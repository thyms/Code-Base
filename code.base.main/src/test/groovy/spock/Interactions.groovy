package spock

import spock.lang.Specification;

class Interactions extends Specification {
	def pub = new Publisher()
	def sub1 = Mock(Subscriber)		// "dynamic" style
	Subscriber sub2 = Mock()		// "static" style
	
	def setup() {
		pub.subscribers << sub1 << sub2
	}
	
	def "A publisher deliver events to alive subscribers"() {
		setup:
		sub1.isAlive() >> true
		sub2.isAlive() >> false
		
		when:
		pub.send("event")
		
		then:
		1 * sub1.receive("event")
		0 * sub2.receive("event")
	}
	
	def "A publisher deliver events to alive subscribers with customr return"() {
		setup:
		sub1.isAlive() >> {return true}
		sub2.isAlive() >> false
		
		when:
		pub.send("event")
		
		then:
		1 * sub1.receive("event")
		0 * sub2.receive("event")
	}	
	
	def "A publisher deliver events to alive subscribers with multi return value"() {
		setup:
		sub1.isAlive() >>> [true, true]
		sub2.isAlive() >>> [true, false]
		
		when:
		pub.send("event")
		pub.send("event")
		
		then:
		2 * sub1.receive("event")
		1 * sub2.receive("event")
	}
	
	def "A publisher deliver events to alive subscribers with interaction with other code"() {
		setup:
		sub1.isAlive() >> true
		sub2.isAlive() >> false
		
		when:
		pub.send("event")
		
		then:
		interaction {
			def time = 1
			time * sub1.receive("event")
			sub2ReceivesZeroMessage()
		}
	}
	
	def sub2ReceivesZeroMessage() {
		0 * sub2.receive(_)
	}
	
	def "A publisher deliver events to alive subscribers with ordered interactions"() {
		setup:
		sub1.isAlive() >> true
		sub2.isAlive() >> true
		
		when:
		pub.send("event")
		
		then:
		1 * sub1.receive("event")
		
		then:
		1 * sub2.receive("event")
	}
	
	def "A publisher deliver events to alive subscribers with argument constraints"() {
		setup: sub1.isAlive() >> true
		when: pub.send("event")
		then: (1.._) * _.receive(_)						// any mock with any argument
				// sub1.receive(!null)                  // any non-null argument
				// sub1.receive(event)                  // any argument equal to event
				// sub1.receive(!event)                 // any argument not equal to event
				// sub1.receive(_ as Message)           // any argument that is-a Message (null is not allowed)
				// sub1.receive( { it.priority >= 5 } ) // custom constraint
				// mock.foo(_, !null, { it ==~ /a*b/ }) // any first arg, second arg non-null, third arg matching the given regex
				// sub1./set.*/(_) // any setter is called on subscriber (any regular expression allowed)
	}
	
	class Publisher {
		def subscribers = []
		def send(event) {
			subscribers.each {
				try {
					if(it.isAlive())
						it.receive(event)
				} catch (Exception e) {

				}
			}
		}
	}

	interface Subscriber {
		def isAlive()
		def receive(event)
	}
}

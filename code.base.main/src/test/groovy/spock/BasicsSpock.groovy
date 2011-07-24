package spock

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class BasicsSpock extends Specification {

	def setupSpec() {
	}		// runs before the first feature method
	def cleanupSpec() {}	// runs after the last feature method

	def setup() {}			// runs before every feature method
	def cleanup() {}		// runs after every feature method

	// Blocks of a Feature Method
	// setup:
	// when:
	// then:
	// expect:
	// cleanup:
	// where:

	@Shared sql = new Sql()		// Very expensiver resource, shared by all Feature Methods

	def "First impression is important;)"() {
		expect:
		name.size() == length

		where:
		name		|	length
		"Spock"		|	5
		"Kirk"		|	4
		"Scotty"	|	6
	}

	def "Setup/When/Then blocks"() {
		setup: def a = 2
		when: a = a*a
		then: a == 4
	}
	
	def "Catching a thrown exception"() {
		setup: def a = null
		when: a.size()
		then: thrown(NullPointerException)
	}
	
	def "Catching and getting the content of a thrown exception"() {
		setup: 	def a = null
		when: 	a.size()
		then:	def e = thrown(NullPointerException) // or NullPointerException e = thrown() 
				e.cause == null
		
	}
	
	def "Not expecting a thrown exception"() {
		setup: def a = "1"
		when: a.size()
		then: notThrown(NullPointerException)
	}
	
	def "When/Then blocks"() {
		when: def x = Math.max(1, 2)
		then: x == 2
	}
	
	def "Expect block, a shortcut to When/Then blocks"() {
		expect: Math.max(1,2) == 2
	}
	
	def "Cleanup block, inside a feature"() {
		setup: def file = new File("some.txt")
		when: file.createNewFile()
		then: file.exists() == true
		cleanup: file.delete()
	}
	
	def "Helper method usage"() {
		when: def man = [firstName: "Bob", lastName: "Jones"];
		then: matchesOurMan(man)
	}
	
	void matchesOurMan(man) {	// WATCH-OUT -> void
		assert man.firstName == "Bob"
		assert man.lastName == "Jones"
	}
	
	def "Specification as documentation usage of blocks"() {
		setup: 	"a is 2, b is 3"
		def a =2; def b = 3
		
		when:	"try to find the maximum of them"
		def max = Math.max(a, b)
		
		then:	"it should be b"
		b == max
	}
}

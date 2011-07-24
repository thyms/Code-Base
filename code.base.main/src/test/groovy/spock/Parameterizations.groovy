package spock

import spock.lang.Specification;

class Parameterizations extends Specification {
	def "length of Spock's and his friends' names"() {
		expect:
		name.size() == length

		where:
		name     | length
		"Spock"  | 5
		"Kirk"   | 4
		"Scotty" | 6
	}

	def "can you figure out what I'm up to?"() {
		expect:
		name.size() == size

		where:
		name << ["Kirk", "Spock", "Scotty"]
		size << [4, 5, 6]
	}
	
	//	where:
	//	[name, age, gender] = sql.execute("select name, age, sex from customer")
	
	//	where:
	//	[name, _, gender] = sql.execute("select name, age, sex from customer")
}

/**
 * 
 */
package spock

import spock.lang.*;

/**
 * @author Deniz KALFA
 *
 */
class Deneme extends Specification {
	def "computing the maximum of two numbers"() {
		expect:
		Math.max(a, b) == c
	  
		where:
		a	|	b	|	c
		5	|	1	|	5
		3	|	9	|	9
	  }
}

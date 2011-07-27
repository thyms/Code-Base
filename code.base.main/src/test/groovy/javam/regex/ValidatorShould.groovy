/**
 * 
 */
package javam.regex

import spock.lang.Specification

/**
 * @author Deniz KALFA
 *
 */
class ValidatorShould extends Specification {
	def "validate correctly according to given username"() {
		setup:
		def usernameValidator = new UsernameValidator()
		
		expect:
		def actualMatch = usernameValidator.validate(username)
		actualMatch == expectedMatch
		
		where:
		username		|	expectedMatch
		'deniz'			|	true
		'deniz123'		|	true
		'deniz_123'		|	true
		'de'			|	false
		'deniz@123'		|	false
	}
	
	def "validate correctly according to given password"() {
		setup:
		def passwordValidator = new PasswordValidator()
		
		expect:
		def actualMatch = passwordValidator.validate(password)
		actualMatch  == expectedMatch
		
		where:
		password		|	expectedMatch
		'dkalfa1A@'		|	true
		'dkAlfa12$'		|	true
		'dkAlfa'		|	false
	}
}

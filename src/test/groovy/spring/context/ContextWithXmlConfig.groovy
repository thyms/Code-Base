/**
 * 
 */
package spring.context

import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.car.*
import spock.lang.Specification;

/**
 * @author Deniz KALFA
 *
 */
class ContextWithXmlConfig extends Specification {
	def "should generate objects"() {
		when:
		def context = new ClassPathXmlApplicationContext("application-config.xml")
		def car = context.getBean("car", Car.class)
		def engine = context.getBean("engine", Engine.class)
		
		then:
		car != null
		engine != null
		engine == car.getEngine()
	}
}

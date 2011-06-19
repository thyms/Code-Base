package spring.context

import model.car.Car;
import model.car.Engine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import springframework.context.model.car.*
import spock.lang.Specification

/**
* @author Deniz KALFA
*
*/
class ContextWithJavaConfig extends Specification {
	def "should generate objects"() {
		when:
		def applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)
		def car = applicationContext.getBean(Car.class)
		def engine = applicationContext.getBean(Engine.class)
		
		then:
		car != null
		engine != null
		engine == car.getEngine()
	}
}

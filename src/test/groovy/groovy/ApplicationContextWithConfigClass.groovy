package groovy
import org.springframework.config.java.context.JavaConfigApplicationContext

import spock.lang.*
import springframework.context.model.car.ApplicationConfig
import springframework.context.model.car.Car
import springframework.context.model.car.Engine

class ApplicationContextWithConfigClass extends Specification {
	def "should generate objects"() {
		context = new JavaConfigApplicationContext(ApplicationConfig.class)
		car = context.getBean(Car.class);
		engine = context.getBean(Engine.class)

		car != null
		engine != null
	}
}
package springframework.context;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springframework.context.model.car.Car;
import springframework.context.model.car.Engine;


public class ApplicationContextWithXmlConfig {
	@Test
	public void generateObjects() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		Car car = context.getBean("car", Car.class);
		Engine engine = context.getBean("engine", Engine.class);
		
		assertNotNull(car);
		assertNotNull(engine);
		assertEquals(engine, car.getEngine());
	}
}

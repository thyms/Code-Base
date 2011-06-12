package springframework.context;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.config.java.context.JavaConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import springframework.context.model.car.ApplicationConfig;
import springframework.context.model.car.Car;
import springframework.context.model.car.Engine;


public class ApplicationContextWithJavaConfig {
	@Test
	public void generateObjects() throws Exception {
		ApplicationContext context = new JavaConfigApplicationContext(ApplicationConfig.class);
		Car car = context.getBean(Car.class);
		Engine engine = context.getBean(Engine.class);
		
		assertNotNull(car);
		assertNotNull(engine);
		assertEquals(engine, car.getEngine());
	}
}

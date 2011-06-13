package springframework.context.model.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
	@Bean
	public Car car() {
		return new Car(engine());
	}

	@Bean
	public Engine engine() {
		return new Engine();
	}
}

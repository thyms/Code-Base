package springframework.context.model.car;

import org.springframework.context.annotation.Bean;

public class ApplicationConfig {
	public @Bean Car car() {
		return new Car(engine());
	}

	public @Bean Engine engine() {
		return new Engine();
	}
}

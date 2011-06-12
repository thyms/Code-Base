package springframework.context.model.car;

public class Car {
	private Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}
}

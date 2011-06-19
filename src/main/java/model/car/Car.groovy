/**
 * 
 */
package model.car

/**
 * @author Deniz KALFA
 *
 */
class Car {
	private Engine engine
	
	public Car(Engine engine) {
		this.engine = engine
	}
	
	def getEngine(){
		return engine;
	}
}

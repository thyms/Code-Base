/**
 * 
 */
package javam.concurrent;


/**
 * @author Deniz KALFA
 * 
 */
public class Deneme implements Runnable {

	public void run() {
		System.out.println("Start..");
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new Deneme());
		thread.start();

		//
		// Get the state of the thread.
		//
		Thread.State state = thread.getState();
		System.out.println("State: " + state.name());
	}
}

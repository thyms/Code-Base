/**
 * 
 */
package javam.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerSynchronizedExample {
	public static void main(String[] args) {
		CubbyHole cubbyHole = new CubbyHole();

		Thread producer = new Producer(cubbyHole);
		Thread consumer = new Consumer(cubbyHole);

		System.out.println("Starting producer");
		producer.start();
		System.out.println("Starting consumer");
		consumer.start();
	}

	private static class Producer extends Thread {
		private final CubbyHole cubbyHole;

		public Producer(CubbyHole cubbyHole) {
			this.cubbyHole = cubbyHole;
		}

		@Override
		public void run() {
			System.out.println("Started producer");
			cubbyHole.put(5);
			System.out.println("Producer: CubbyHole value: " + cubbyHole.value);
		}
	}

	private static class Consumer extends Thread {
		private final CubbyHole cubbyHole;

		public Consumer(CubbyHole cubbyHole) {
			this.cubbyHole = cubbyHole;
		}

		@Override
		public void run() {
			System.out.println("Started consumer");
			System.out.println("Consumer: CubbyHole value: " + cubbyHole.get());
		}
	}

	private static class CubbyHole {
		private int value = 0;

		public synchronized int get() {
			System.out.println("Consumer is getting...");
			return value;
		}

		public synchronized void put(int value) {
			try {
				System.out.println("Producer is putting...");
				Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(2));
				this.value = value;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

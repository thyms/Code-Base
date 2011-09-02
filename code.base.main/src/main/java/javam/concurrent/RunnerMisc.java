/**
 * 
 */
package javam.concurrent;

import model.customer.Customer;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerMisc {
	private static volatile Customer customer = new Customer();
	private static volatile int count = 10;

	public static void main(String[] args) throws InterruptedException {
		customer = new Customer();
		customer.setFirstName("Joe");
		customer.setLastName("Black");
		System.out.println("#" + ": " + customer);
		System.out.println("#" + ": " + "Count: " + count);

		String threadName1 = "Thread1";
		System.out.println("Starting " + threadName1);
		RunnableRunner runnable = new RunnableRunner(threadName1, 0, 4000);
		Thread thread = new Thread(runnable);
		thread.setName(threadName1);
		thread.start();

		String threadName2 = "Thread2";
		System.out.println("Starting " + threadName2);
		RunnableRunner runnable2 = new RunnableRunner(threadName2, 0, 0);
		Thread thread2 = new Thread(runnable2);
		thread2.setName(threadName2);
		thread2.start();
		
		Thread.sleep(5000);
		System.out.println("#" + ": " + customer);
		System.out.println("#" + ": " + "Count: " + count);
	}

	private static class RunnableRunner implements Runnable {
		private final String name;
		private final int amountToSleepPre;
		private final int amountToSleepPost;

		public RunnableRunner(String name, int amountToSleepPre, int amountToSleepPost) {
			this.name = name;
			this.amountToSleepPre = amountToSleepPre;
			this.amountToSleepPost = amountToSleepPost;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(amountToSleepPre);
				
				System.out.println("#" + name+ ": " + customer);
				System.out.println("#" + name+ ": " + "Count: " + count);
				customer.setFirstName("Tom" + name);
				customer.setLastName("Donald" + name);
				count = 15;

				Thread.sleep(amountToSleepPost);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

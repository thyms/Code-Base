
//public class Deneme {
//	private static class SimpleThread extends Thread {
//		private final CyclicBarrier cyclicBarrier;
//		private int count = 5;
//
//		public SimpleThread(int i, CyclicBarrier cyclicBarrier) {
//			this.cyclicBarrier = cyclicBarrier;
//			setName(String.valueOf(i));
//		}
//
//		@Override
//		public void run() {
//			try {
//				cyclicBarrier.await();
//				do {
//					System.out.println(getName() + ": count is " + count);
//				} while (--count  != 0);
//				System.out.println(getName() + ": is done working...");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (BrokenBarrierException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		int numberOfThreads = 10;
//		CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreads, new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("All Threads are ready to start");
//			}
//		});
//		
//		for (int i = 0; i < numberOfThreads; i++) {
//			SimpleThread simpleThread = new SimpleThread(i, cyclicBarrier);
//			simpleThread.start();
//		}
//		
//		System.out.println(Thread.currentThread().getName() + ": Main thread is done");
//	}
//}

//MyThread t1 = new MyThread(1);
//MyThread t2 = new MyThread(2);
//
//t1.setPriority(Thread.NORM_PRIORITY);
//t2.setPriority(Thread.NORM_PRIORITY);   // won't yield() for lower priority
//t1.start();
//t2.start();
//		
//class MyThread extends Thread {
//	int id;
//	
//	MyThread(int id) {
//		this.id = id;
//	}
//	
//	public synchronized void run(){
//		for(int i=0; i<100; i++) {
//			if( id==1 && i==30 ) {
//					yield();
//			}
//			System.out.println("My id is: " + id);
//		}
//	}
//}

//StackClass stack = new StackClass(5);
//new StackPusher("One", stack);
//new StackPusher("Two", stack);
//new StackPopper("Three", stack);
//System.out.println("Main Thread sleeping.");
//try {
//	Thread.sleep(500);
//} catch (InterruptedException e) {
//	e.printStackTrace();
//}
//System.out.println("Exit from Main Thread.");
//
//
//class StackClass {
//	
//		private Object[] stackArray;
//		private volatile int topOfStack;
//		StackClass(int capacity) {
//			stackArray = new Object[capacity];
//			topOfStack = -1;
//		}
//		public synchronized Object pop() {
//			System.out.println(Thread.currentThread() + ": popping");
//			while (isEmpty()) {
//				try {
//					System.out.println(Thread.currentThread()
//							+ ": waiting to pop");
//					wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			Object obj = stackArray[topOfStack];
//			stackArray[topOfStack--] = null;
//			System.out.println(Thread.currentThread()
//					+ ": notifying after pop");
//			notify();
//			return obj;
//		}
//		public synchronized void push(Object element) {
//			System.out.println(Thread.currentThread() + ": pushing");
//			while (isFull()) {
//				try {
//					System.out.println(Thread.currentThread()
//							+ ": waiting to push");
//					wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			stackArray[++topOfStack] = element;
//			System.out.println(Thread.currentThread()
//					+ ": notifying after push");
//			notify();
//		}
//		public boolean isFull() {
//			return topOfStack >= stackArray.length - 1;
//		}
//		public boolean isEmpty() {
//			return topOfStack < 0;
//		}
//	}
//	
//	abstract class StackUser extends Thread {
//	
//		protected StackClass stack;
//		StackUser(String threadName, StackClass stack) {
//			super(threadName);
//			this.stack = stack;
//			System.out.println(this);
//			setDaemon(true);
//			start();
//		}
//	}
//	
//	class StackPopper extends StackUser { // Stack Popper
//	
//		StackPopper(String threadName, StackClass stack) {
//			super(threadName, stack);
//		}
//		public void run() {
//			while (true) {
//				stack.pop();
//			}
//		}
//	}
//	
//	class StackPusher extends StackUser { // Stack Pusher
//	
//		StackPusher(String threadName, StackClass stack) {
//			super(threadName, stack);
//		}
//		public void run() {
//			while (true) {
//				stack.push(new Integer(1));
//			}
//		}
//	}
//	

//import java.util.concurrent.TimeUnit;
//
//println 'Main: 1'
//def thread = new Thread() {
//	public void run() {
//		println 'Thread: 1'
//		try {
//			sleep(TimeUnit.SECONDS.toMillis(10))
//		} catch(Exception e) {
//			println 'Thread: interrupted...'
//		}
//		
//		println 'Thread: 2'
//	}
//	
//}
//println 'Main: 2'
//
//thread.start()
//Thread.sleep(TimeUnit.SECONDS.toMillis(2))
//thread.interrupt()
//Thread.sleep(TimeUnit.SECONDS.toMillis(2))
//
//println 'Main: 3'



//SyncBlockExample thread1 = new SyncBlockExample("thread1: ");
//SyncBlockExample thread2 = new SyncBlockExample("thread2: ");
//thread1.start();
//thread2.start();
//boolean t1IsAlive = true;
//boolean t2IsAlive = true;
//while (t1IsAlive || t2IsAlive) {
//	if (t1IsAlive && !thread1.isAlive()) {
//		t1IsAlive = false;
//		System.out.println("t1 is dead.");
//	}
//	if (t2IsAlive && !thread2.isAlive()) {
//		t2IsAlive = false;
//		System.out.println("t2 is dead.");
//	}
//} 
//
//
//public class SyncBlockExample extends Thread {
//
//	static String[] msg = ["Beginner", "java", "tutorial,", ".,", "com", "is", "the", "best" ];
//	public SyncBlockExample(String id) {
//		super(id);
//	}
//	
//	void randomWait() {
//		try {
//			Thread.currentThread().sleep((long) (3000 * Math.random()));
//		} catch (InterruptedException e) {
//			System.out.println("Interrupted!");
//		}
//	}
//	public void run() {
//		synchronized (System.out) {
//			for (int i = 0; i < msg.length; i++) {
//				randomWait();
//				System.out.println(getName() + msg[i]);
//			}
//		}
//	}
//}
package threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemp {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		new Thread(() -> {
		    System.out.println("Task 1 done");
		    latch.countDown();
		}).start();

		new Thread(() -> {
		    System.out.println("Task 2 done");
		    latch.countDown();
		}).start();

		new Thread(() -> {
		    System.out.println("Task 3 done");
		    latch.countDown();
		}).start();

		latch.await(); // main waits
		System.out.println("All tasks completed");
	}
}

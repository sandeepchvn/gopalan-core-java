package threads;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, () -> {
		    System.out.println("All threads reached barrier");
		});

		Runnable task = () -> {
		    try {
		        System.out.println(Thread.currentThread().getName() + " waiting");
		        barrier.await();
		        System.out.println(Thread.currentThread().getName() + " continues");
		    } catch (Exception e) {}
		};

		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
	}
}

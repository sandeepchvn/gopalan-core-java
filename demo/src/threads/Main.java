package threads;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();   // acquire lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " -> " + count);
        } finally {
            lock.unlock(); // always release
        }
    }
//    tryLock() Example (VERY IMPORTANT)
    public static void m1() {
    	ReentrantLock lock = new ReentrantLock();
    	if (lock.tryLock()) {
    	    try {
    	        System.out.println("Lock acquired");
    	    } finally {
    	        lock.unlock();
    	    }
    	} else {
    	    System.out.println("Could not acquire lock");
    	}
    }
//    tryLock with Timeout
    public static void m2() throws InterruptedException {
    	ReentrantLock lock = new ReentrantLock();
    	if (lock.tryLock(2, java.util.concurrent.TimeUnit.SECONDS)) {
    	    try {
    	        System.out.println("Got lock within 2 seconds");
    	    } finally {
    	        lock.unlock();
    	    }
    	} else {
    	    System.out.println("Timeout - could not get lock");
    	}
    }
}

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
    }
    
    
}

//Reentrant Behavior Example
class Example {
    ReentrantLock lock = new ReentrantLock();

    void methodA() {
        lock.lock();
        try {
            System.out.println("Inside A");
            methodB();
        } finally {
            lock.unlock();
        }
    }

    void methodB() {
        lock.lock(); // same thread locks again
        try {
            System.out.println("Inside B");
        } finally {
            lock.unlock();
        }
    }
}

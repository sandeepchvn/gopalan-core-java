package threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        // Reader threads
        Runnable readTask = () -> {
            for (int i = 0; i < 3; i++) {
                resource.readData();
            }
        };

        // Writer thread
        Runnable writeTask = () -> {
            for (int i = 1; i <= 3; i++) {
                resource.writeData(i * 10);
            }
        };

        new Thread(readTask, "Reader-1").start();
        new Thread(readTask, "Reader-2").start();
        new Thread(writeTask, "Writer").start();
    }
}

class SharedResource {

    private int data = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    // READ operation
    public void readData() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " READ: " + data);

            Thread.sleep(1000); // simulate read delay

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    // WRITE operation
    public void writeData(int value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " WRITING: " + value);

            data = value;
            Thread.sleep(1000); // simulate write delay

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

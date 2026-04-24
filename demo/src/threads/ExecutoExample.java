package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutoExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		Future<Integer> res=executorService.submit(()-> {return 2+4;});
		System.out.println(res.get());
		System.out.println(res.isDone());
		executorService.shutdown();
		System.out.println(executorService.isTerminated());
	}
}

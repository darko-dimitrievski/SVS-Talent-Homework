import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxResultApplication {

	private static final int NUMBER_OF_OPERATIONS = 10;

	public static void main(String[] args) throws Exception {
		int max = Integer.MIN_VALUE;
		ArrayList<Future<Integer>> arrayOfIntegers = new ArrayList<Future<Integer>>();
		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
		final ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
			Callable<Integer> callable = new ComplexCalculation(i, latch);
			Future<Integer> future = executorService.submit(callable);
			arrayOfIntegers.add(future);
		}
		for (Future<Integer> result : arrayOfIntegers) {
			if(result.get() > max) max = result.get();
		}
		System.out.println(max);

		executorService.shutdown();
	}
}

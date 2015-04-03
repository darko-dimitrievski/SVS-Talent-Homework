import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ComplexCalculation implements Callable<Integer> {

	private Integer orderNumber;
	private CountDownLatch latch;
	Random random = new Random();

	public ComplexCalculation(Integer orderNumber, CountDownLatch latch) {
		this.orderNumber = orderNumber;
		this.latch = latch;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return random.nextInt(10);
	}
}

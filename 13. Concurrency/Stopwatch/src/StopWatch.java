public class StopWatch implements Runnable {

	boolean flag = false;
	int counter;

	@Override
	public void run() {
		while (flag) {
			System.out.println(counter);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException ee) {
				}
			}
			counter++;
		}

	}

}
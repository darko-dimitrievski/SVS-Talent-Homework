public class NumberPrinter {

	public static void main(final String[] args) throws Exception {
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < Integer.parseInt(args[0]); i++) {
					System.out.println(i);
					if (Thread.interrupted()) {
						return;
					}
				}
			}
		};
		t.start();
		Thread.sleep(Integer.parseInt(args[1]));
		System.out.println("Interupting the task...");
		t.interrupt();
	}
}

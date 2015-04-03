import java.util.Scanner;

public class StopWatchApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StopWatch stopwatch = new StopWatch();
		Thread stopwatchThread = new Thread(stopwatch);

		System.out.println("START to start the stopwatch");
		System.out.println("PAUSE to pause the stopwatch");
		System.out.println("STOP to finish");

		while (true) {
			switch (scanner.next()) {
			case "START":
				if (!stopwatch.flag) {
					stopwatch.flag = true;
					stopwatchThread.start();
				} else {
					synchronized (stopwatch) {
						stopwatch.notify();
					}
				}
				break;
			case "PAUSE":
				stopwatchThread.interrupt();
				break;

			case "STOP":
				System.out.println("Total:" + stopwatch.counter + " seconds");
				break;
			}
		}

	}
}
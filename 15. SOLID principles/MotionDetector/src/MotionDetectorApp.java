import imageCapture.ImageCaptureDevice;
import alarm.Alarm;
import alarm.Police;
import motionDetection.MotionDetector;

public class MotionDetectorApp {
	public static void main(String[] args) {
	ImageCaptureDevice device = new ImageCaptureDevice();
	Alarm alarm = new Police();
	MotionDetector motionDetector = new MotionDetector(device, alarm);
		motionDetector.run();
	}
}

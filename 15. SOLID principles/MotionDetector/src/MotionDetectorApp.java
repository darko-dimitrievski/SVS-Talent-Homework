import md.alarm.Alarm;
import md.alarm.Police;
import md.imageCapture.ImageCaptureDevice;
import md.motionDetection.MotionDetector;

public class MotionDetectorApp {
	public static void main(String[] args) {
	ImageCaptureDevice device = new ImageCaptureDevice();
	Alarm alarm = new Police();
	MotionDetector motionDetector = new MotionDetector(device, alarm);
		motionDetector.run();
	}
}

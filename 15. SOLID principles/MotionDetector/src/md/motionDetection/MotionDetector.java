package md.motionDetection;

import md.alarm.Alarm;
import md.imageCapture.ImageCaptureDeviceImpl;

public class MotionDetector implements MotionDetectorImpl {

	ImageCaptureDeviceImpl device;
	Alarm alarm;
	String image1;
	String image2;

	public MotionDetector(ImageCaptureDeviceImpl device, Alarm alarm) {
		this.device = device;
		this.alarm = alarm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		image1 = device.takePicture();
		while (true) {
			image2 = device.takePicture();
			if (image1.equals(image2))
				alarm.alert();
			else image1=image2;
		}
	}

}

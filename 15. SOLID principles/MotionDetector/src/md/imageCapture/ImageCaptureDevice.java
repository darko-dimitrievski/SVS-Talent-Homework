package md.imageCapture;

import java.util.Scanner;

public class ImageCaptureDevice implements ImageCaptureDeviceImpl {
	Scanner scanner = new Scanner(System.in);

	@Override
	public String takePicture() {
		// TODO Auto-generated method stub
		System.out.println("Entering the image..");
		return scanner.nextLine();
	}

	@Override
	public void turnOf() {
		scanner.close();
	}

}

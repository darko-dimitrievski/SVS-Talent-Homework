public class BoxVolume {
	public static void main(String[] args) {
		Box a = new Box(10, 2, 4);
		Box b = new Box(11, 3, 3);

		System.out.print("Pogolem volumen ima ");
		if (a.Volumen() > b.Volumen()) {
			System.out.print("kutijata a so dimenzii " + a.depth + ","
					+ a.height + "," + a.weight);
		} else {
			System.out.print("kutijata b so dimenzii " + b.depth + ","
					+ b.height + "," + b.weight);
		}
	}

}


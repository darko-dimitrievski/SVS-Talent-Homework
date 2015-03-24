public class Box {
	int height, weight, depth;

	public Box(int height, int weight, int depth) {
		this.height = height;
		this.weight = weight;
		this.depth = depth;
	}

	public int Volumen() {
		return height * weight * depth;
	}

}
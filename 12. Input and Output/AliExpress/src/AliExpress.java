import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AliExpress {
	static Warehouse warehouse;
	static ShoppingBasket shoppingBasket;
	static int total = 0;

	public static void main(String[] args) throws OutOfProduct {
		loadProducts();
		menu();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			switch (scanner.nextInt()) {
			case 1:
				warehouse.listAllProducts();
				menu();
				break;
			case 2:
				addProductToShoppingBasket();
				menu();
				break;
			case 3:
				System.out.println("The sum that you have to pay is " + total);
				break;
			case 4:
				warehouse.adminlistAllProducts();
				break;
			}
		}
		scanner.close();
	}

	public static void menu() {
		System.out.println("===============================");
		System.out.println("Menu");
		System.out.println("Press 1 for listing all products");
		System.out.println("Press 2 to add product to the shopping basket");
		System.out.println("Press 3 for payment service");
		System.out.println("Press 4 for more warehouse informations (Admin part)");
		System.out.println("===============================");
	}

	public static void loadProducts() {
		BufferedReader bufferedReader;
		warehouse = new Warehouse();
		try {
			bufferedReader = new BufferedReader(
					new FileReader(
							"C:\\Users\\Darko\\Desktop\\Eclipse Projects\\AliExpress\\src\\products.txt"));
			String line = null;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					String[] parts = line.split("\\|");
					if (warehouse.products.containsKey(parts[0])) {
						warehouse.products.get(parts[0]).setQuantity(
								warehouse.products.get(parts[0]).getQuantity()
										+ Integer.parseInt(parts[3]));
					} else {
						for (int i = 0; i < parts.length; i++) {

							Product product = new Product(parts[0], parts[1],
									Integer.parseInt(parts[2]),
									Integer.parseInt(parts[3]));
							warehouse.addProduct(parts[0], product);

						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void addProductToShoppingBasket() throws OutOfProduct {
		shoppingBasket = new ShoppingBasket();
		Scanner s = new Scanner(System.in);
		System.out.println("Insert the name of article and the quantity");
		while (s.hasNextLine()) {
			System.out
					.println("Insert the name of another article and the quantity");
			String[] parts = s.nextLine().split(" ");
			if (warehouse.products.containsKey(parts[0])) {
				if (Integer.parseInt(parts[1]) > warehouse.products.get(
						parts[0]).getQuantity()) {
					throw new OutOfProduct();
				} else {
					shoppingBasket.addProductInShoppingBasket(
							Integer.parseInt(parts[1]),
							warehouse.products.get(parts[0]));
					warehouse.products.get(parts[0]).setQuantity(
							warehouse.products.get(parts[0]).getQuantity()
									- Integer.parseInt(parts[1]));
					total += Integer.parseInt(parts[1]) * warehouse.products.get(parts[0]).getPrice();
				}
			} else {
				System.out.println("No  product in the warehouse");
			}

		}
	}
}

public class Library {
	public static void main(String[] args) {
		BusinessLogic bl = new BusinessLogic();
		bl.addBook("121", "probaKniga");
		bl.updateBook("121", "novoIme");
		bl.listAllBooks();
		bl.deleteBook("1234");
		System.out.println("=======================");
		bl.listAllBooks();
	}
}

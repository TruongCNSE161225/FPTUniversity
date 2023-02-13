
public class BookManagement {

    public static void main(String args[]) {

        String[] options = {"Add a new book", "Find a book",
            "Print the book list", "Quit"};
        int choice = 0;
        BookList list = new BookList();
        do {
            System.out.println("\n----------BOOK MANAGER----------");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    list.addBook();
                    break;
                case 2:
                    list.searchBook();
                    break;
                case 3:
                    list.printBookList();
                    break;
                default:
                    System.out.println("Good Bye!");
            }
        } while (choice > 0 && choice < 4);
    }
}

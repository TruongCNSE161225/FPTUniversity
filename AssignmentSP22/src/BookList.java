
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class BookList extends ArrayList<Book> {

    Scanner sc = new Scanner(System.in);
    Vector<String> storedCodes = new Vector<String>();

    public BookList() {
        super();
    }

    public void printBookList() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Book list: ");
            for (Book bk : this) {
                System.out.println(bk);
            }
            for (Book sr : this){
                System.out.println("Sort by quantity: ");
                Collections.sort(this);
                System.out.println(sr);
            }
            System.out.println("Total: " + this.size() + " book(s)");
        }
    }

    private boolean valid(String aCode) {
        int i;
        for (i = 0; i < storedCodes.size(); i++) {
            if (aCode.equals(storedCodes.get(i))) {
                return false;
            }
        }
        for (i = 0; i < this.size(); i++) {
            if (!aCode.equals(this.get(i).getCode())) {
            } else {
                return false;
            }
        }
        return true;
    }

    public void addBook() {
        String newCode, newTitle;
        float newUnitPrice;
        int newQuantity;
        boolean duplicated = false;
        System.out.println("\nEnter New Book Details:");
        do {
            System.out.print("  Code: ");
            newCode = sc.nextLine();
            duplicated = !valid(newCode);
            if (duplicated) {
                System.out.println("  The code is duplicated.");
            }
        } while (duplicated);
        System.out.print("  Name: ");
        newTitle = sc.nextLine();
        System.out.print("  Unit price: ");
        newUnitPrice = Float.parseFloat(sc.nextLine());
        System.out.print("  Quantity: ");
        newQuantity = Integer.parseInt(sc.nextLine());
        this.add(new Book(newCode, newTitle, newUnitPrice, newQuantity));
        System.out.println("New book has been added.");
    }

    public Book search(String code) {
        code = code.trim();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    public void searchBook() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No search can be performed!");
        } else {
            String sCode = Inputter.inputStr("Input book code for search: ");
            Book bk = this.search(sCode);
            if (bk == null) {
                System.out.println("Not Found");
            } else {
                System.out.println("Found: " + bk);
            }
        }
    }
}

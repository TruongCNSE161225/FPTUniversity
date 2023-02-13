package employees;

import java.util.Vector;
import java.util.Scanner;

public class Menu extends Vector<String> {

    public Menu() {
        super();
    }

    void addMenuItem(String S) {
        this.add(S);
    }

    public static int getUserChoice() {
        String[] options = {"Add new employee", "Remove an emloyee","Promoting the employee's salary", "Print the list", "Save to files","Quit"}; 
        for (int i = 0; i < options.length;  i++) {
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.print("Choose 1..." + options.length + ": ");
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }
}

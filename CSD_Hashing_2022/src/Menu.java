
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {

    Scanner sc = new Scanner(System.in);

    int getUserChoice() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println("" + (i + 1) + "-" + this.get(i));
        }
        System.out.println("Choose operation:");
        return Integer.parseInt(sc.nextLine());
    }
}

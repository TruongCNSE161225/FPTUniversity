
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {

    static Scanner sc = new Scanner(System.in);

    public Menu() {
        super();
    }

    public int getChoice() {
        int i = 1;
        for (String option : this) {
            System.out.println((i++) + "-" + option);
        }
        System.out.print("Choose: ");
        return Integer.parseInt(sc.nextLine());
    }
}

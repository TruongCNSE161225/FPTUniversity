
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static int getChoice(ArrayList options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "-" + options.get(i));
        }
        System.out.print("Choose 1 to " + options.size() + ": ");
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }

    public static int getChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.print("Choose 1 to " + options.length + ": ");
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }
}

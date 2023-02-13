import java.util.Scanner;

public class NewClass2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input vi tri can tim: ");
        int n = sc.nextInt();
        double del = 1 - 4 * (-2 * n);
        double x = ((-1 + Math.sqrt(del)) / 2);
        x = Math.floor(x);
        System.out.println(x);
        for (int i = 1; i <= x; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("1,");
                }
            } else {
                for (int j = 1; j <= i; j++) {
                    System.out.print("0,");
                }

            }

        }
        x = (x * (x + 1)) / 2;
        if (n > x && x % 2 != 0) {
            System.out.println("\nGia tri tai vi tri " + n + " la: " + 1);
        } else if (n > x && x % 2 == 0) {
            System.out.println("\nGia tri tai vi tri " + n + " la: " + 0);
        }
    }
}
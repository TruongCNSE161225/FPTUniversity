package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyUtil {

    static Scanner sc = new Scanner(System.in);

    public static String readNonBlankStr(String message) {
        String S;
        boolean OK = true;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim();
            if (S == null || S.isEmpty()) {
                OK = false;
                System.out.println("Invalid input!");
            } else {
                return S;
            }
        } while (!OK);
        return null;
    }

    public static String readNonBlankStrUp(String message) {
        String S;
        System.out.print(message + ": ");
        S = sc.nextLine().trim();
        if (S.equals("\n")) {
            return null;
        } else {
            return S;
        }
    }

    public static int readInt(String message, int min, int max) {
        int t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {
            System.out.print(message + ": ");
            t = Integer.parseInt(sc.nextLine());
            if (t >= min && t <= max) {
                OK = true;
            } else {
                System.out.println("Invalid input!");
            }
        } while (!OK);
        return t;
    }

    public static int readInt(String message, int min) {
        return readInt(message, min, Integer.MAX_VALUE);
    }
}

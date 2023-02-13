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

    public static boolean readBool(String message) {
        String S;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim().toUpperCase();
            if (S.length() > 0) {
                char c = S.charAt(0);
                return (c == '1');
            }
        } while (S.length() <= 0);
        return false;
    }

    public static boolean readBoolUp(String message) {
        String S;
        System.out.print(message + ": ");
        S = sc.nextLine().trim().toUpperCase();
        if (S.length() > 0) {
            char c = S.charAt(0);
            return (c == '1');
        }
        if (S.length() == 0) {
            return false;
        }
        return false;
    }

    public static boolean readBoolDe(String message) {
        String S;
        System.out.print(message + ": ");
        S = sc.nextLine().trim().toUpperCase();
        char c = S.charAt(0);
        if (c == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static String convertDateFormat(Date d) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        if (d != null) {
            return DateFor.format(d);
        }
        return null;
    }
}

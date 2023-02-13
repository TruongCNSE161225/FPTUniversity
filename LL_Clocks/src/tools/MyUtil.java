package tools;

import java.util.Scanner;

public class MyUtil {

    public static Scanner sc = new Scanner(System.in);

    public static int readInt(String message, int min, int max) {
        int t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK;
        do {
            System.out.print(message + ": ");
            t = Integer.parseInt(sc.nextLine());
            OK = (t >= min && t <= max);
        } while (!OK);
        return t;
    }

    public static int readInt(String message, int min) {
        return readInt(message, min, Integer.MAX_VALUE);
    }

    public static double readDouble(String message, double min, double max) {
        double t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {
            System.out.print(message + ": ");
            t = Double.parseDouble(sc.nextLine());
            OK = (t >= min && t <= max);
        } while (!OK);
        return t;
    }

    public static double readDouble(String message, double min) {
        return readDouble(message, min, Double.MAX_VALUE);
    }

    public static String readNonBlankStr(String message) {
        String S;
        boolean OK = true;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim();
            if (S == null || S.isEmpty()) {
                OK = false;
            }
        } while (!OK);
        return S;
    }

    public static String readPattern(String message, String regex) {
        String S;
        boolean OK;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim();
            OK = S.matches(regex);
            if (!OK) {
                System.out.println("Invalid input!");
            }
        } while (!OK);
        return S;
    }

    public static boolean readBool(String message) {
        System.out.print(message + " [T/F, Y/N, 1/0: ");
        String S = sc.nextLine().trim().toUpperCase();
        char c = S.charAt(0);
        return (c == 'T' || c == 'Y' || c == '1');
    }
}

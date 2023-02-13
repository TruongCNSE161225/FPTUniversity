package tools;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyUtil {

    public static final int DMY = 0;
    public static final int MDY = 1;
    public static final int YMD = 2;

    public static final String PHONE_10to12 = "[\\d]{10,12}";

    public static final String EMAIL = ".+@.+[.].+";

    static Scanner sc = new Scanner(System.in);

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
        if (String.valueOf(t).equals("\n")) {
            return 0;
        } else {
            return t;
        }
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

    public static String readPatternUp(String message, String regex) {
        String S;
        boolean OK;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim();
            OK = S.matches(regex);
            if (S.length() == 0) {
                break;
            }
            if (!OK) {
                System.out.println("Invalid input!");
            }
        } while (!OK);
        if (S.length() != 0) {
            return S;
        }
        return null;
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

    public static String readBoolStr(boolean gender) {
        String S = null;
        if (gender == true) {
            S = "Male";
        } else {
            S = "Female";
        }
        return S;
    }

    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) {
            result = true;
        }
        return result;
    }

    public static boolean valid(int y, int m, int d) {
        if (y < 0 || m < 0 || m > 12 || d < 0 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
    }

    public static Date toDate(int y, int m, int d) {
        if (!valid(y, m, d)) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d);
        return cal.getTime();
    }

    public static Date toDate(String dateStr, int dateFormat) {
        int yIndex, mIndex, dIndex;
        switch (dateFormat) {
            case YMD:
                yIndex = 0;
                mIndex = 1;
                dIndex = 2;
                break;
            case MDY:
                yIndex = 2;
                mIndex = 0;
                dIndex = 1;
                break;
            case DMY:
                yIndex = 2;
                mIndex = 1;
                dIndex = 0;
                break;
            default:
                return null;
        }
        String[] parts = dateStr.split("[/-]");
        if (parts.length != 3) {
            return null;
        }
        int y = Integer.parseInt(parts[yIndex]);
        int m = Integer.parseInt(parts[mIndex]);
        int d = Integer.parseInt(parts[dIndex]);
        return toDate(y, m, d);
    }

    public static Date readDMY(String message) {
        Date d;
        String S;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim();
            d = toDate(S, DMY);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    }

    public static Date readDMYUp(String message) {
        Date d;
        String S;
        do {
            System.out.print(message + ": ");
            S = sc.nextLine().trim();
            d = toDate(S, DMY);
            if (S.length() == 0) {
                break;
            }
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        if (d != null) {
            return d;
        }
        return null;
    }

//    public static Date readDMYUp(String message) {
//        Date d;
//        String S;
//        System.out.print(message + ": ");
//        S = sc.nextLine().trim();
//        if (S.length() > 0) {
//            d = toDate(S, DMY);
//            if (d == null) {
//                System.out.println("Invalid date!");
//            }
//        } else {
//            return null;
//        }
//        return d;
//    }
    public static String StrDMY(Date d) {
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + (c.get(Calendar.DATE)) + '-'
                + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.YEAR);
    }
}

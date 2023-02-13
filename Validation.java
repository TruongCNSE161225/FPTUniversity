package util;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validation {

    private static final Scanner SC = new Scanner(System.in);

    public static int inputInt(String mess) {
        int result = 0;
        try {
            System.out.print(mess);
            result = Integer.parseInt(SC.nextLine());
        } catch (Exception e) {
            System.out.println("Input Data is invalid");
        }
        return result;
    }

    public static float inputFloat(String mess) {
        float result = 0;
        try {
            System.out.print(mess);
            result = Float.parseFloat(SC.nextLine());
        } catch (Exception e) {
            System.out.println("Input Data is invalid");

        }
        return result;
    }

    public static double inputDouble(String mess) {
        double result = 0;
        try {
            System.out.print(mess);
            result = Double.parseDouble(SC.nextLine());
        } catch (Exception e) {
            System.out.println("Input Data is invalid");

        }
        return result;
    }

    public static int inputWithRange(String mess, int a, int b) {
        int max = 0;
        int min = 0;
        int result = 0;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        do {
            result = inputInt(mess);
            if (result < min || result > max) {
                System.out.println("Not meet the conditions");
            } else {
                break;
            }
        } while (result < min || result > max);
        return result;
    }

    public static float inputWithRange(String mess, float a, float b) {
        float max = 0;
        float min = 0;
        float result = 0;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        do {
            result = inputFloat(mess);
            if (result < min || result > max) {
                System.out.println("Not meet the conditions");
            } else {
                break;
            }
        } while (result < min || result > max);
        return result;
    }

    public static double inputWithRange(String mess, double a, double b) {
        double max = 0;
        double min = 0;
        double result = 0;

        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        do {
            result = inputDouble(mess);
            if (result < min || result > max) {
                System.out.println("Not meet the conditions");
            } else {
                break;
            }
        } while (result < min || result > max);
        return result;
    }

    public static float inputWithMin(String mess, float min) {
        float result = 0;
        do {
            result = inputFloat(mess);
            if (result > min) {
                break;
            } else {
                System.out.println("Number more than " + min);
            }
        } while (true);
        return result;
    }

    public static int inputWithMin(String mess, int min) {
        int result = 0;
        do {
            result = inputInt(mess);
            if (result > min) {
                break;
            } else {
                System.out.println("Number more than " + min);
            }
        } while (true);
        return result;
    }

    public static double inputWithMin(String mess, double min) {
        double result = 0;
        do {
            result = inputDouble(mess);
            if (result > min) {
                break;
            } else {
                System.out.println("Number more than " + min);
            }
        } while (true);
        return result;
    }

    public static int inputWithMax(String mess, int max) {
        int result = 0;
        do {
            result = inputInt(mess);
            if (result < max) {
                break;
            } else {
                System.out.println("Number less than " + max);
            }
        } while (true);
        return result;
    }

    public static float inputWithMax(String mess, float max) {
        float result = 0;
        do {
            result = inputFloat(mess);
            if (result < max) {
                break;
            } else {
                System.out.println("Number less than " + max);
            }
        } while (true);
        return result;
    }

    public static double inputWithMax(String mess, double max) {
        double result = 0;
        do {
            result = inputDouble(mess);
            if (result < max) {
                break;
            } else {
                System.out.println("Number less than " + max);
            }
        } while (true);
        return result;
    }

    public static String inputString(String mess) {
        String result = "";
        try {
            System.out.println(mess);
            result = SC.nextLine();
        } catch (Exception e) {
            System.out.println("Input Data is invalid");
        }
        return result;
    }

    public static String inputStringWithLength(String mess, int length) {
        String result = "";
        try {
            do {
                result = inputString(mess);
                if (result.length() == length) {
                    break;
                } else {
                    System.out.println("String has length is not valid");
                }
            } while (result.length() != length);
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static String inputStringWithFormat(String mess, String format) {
        String result = "";
        try {
            while (true) {
                result = inputString(mess);
                boolean isMatch = Pattern.matches(format, result);
                if (isMatch) {
                    break;
                } else {
                    System.out.println("Input data is not in the correct format");
                }
            }
        } catch (Exception e) {
            System.out.println("Has somthing wrong");
        }
        return result;
    }

    public static Date isFormatDate(String strDate) throws ParseException {
        final String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        boolean statusFormat = Pattern.matches(regex, strDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            while (!statusFormat) {
                System.out.println("Wrong format Date!!!");
                strDate = Validation.inputStringWithFormat("String of Date", regex);
                break;
            }
        } catch (Exception e) {
            System.out.println("Has something wrong");
        }
        return formatter.parse(strDate);
    }
}
// updated  on 18/1/2022

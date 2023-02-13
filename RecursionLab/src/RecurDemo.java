
public class RecurDemo {

    //Demo1
    public static double factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //Demo2
    public static int fibo(int n) {
        if (n < 2) {
            return 1;
        }
        return fibo(n - 2) + fibo(n - 1);
    }

    public static boolean testFibo(int x) {
        if (x < 1) {
            return false;
        }
        int aFibo = 1;
        int n = 2;
        while (aFibo < x) {
            aFibo = fibo(n++);
        }
        return x == aFibo;
    }

    //Demo3
    public static double ap(int n, double a, double d) {
        if (n == 1) {
            return a;
        }
        return ap(n - 1, a, d) + d;
    }

    //Demo4
    public static double gp(int n, double a, double q) {
        if (n == 1) {
            return a;
        }
        return gp(n - 1, a, q) * q;
    }

    //Demo5
    public static double sum(double[] a, int n) {
        if (n == 0) {
            return 0;
        }
        return sum(a, n - 1) + a[n - 1];
    }

    //Demo6
    public static double max(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        int m = (int) max(a, n - 1);
        return m > a[n - 1] ? m : a[n - 1];
    }

    //Demo7
    public static double min(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        int m = (int) min(a, n - 1);
        return m < a[n - 1] ? m : a[n - 1];
    }

    //Demo8
    public static String convert(int n, int base) {
        if (n == 0) {
            return "0";
        }
        return convert(n / base, base) + Character.forDigit(n % base, base);
    }

    public static void main(String[] args) {
        System.out.println("Demo1: ");
        System.out.println(factorial(5));
        System.out.println("Demo2: ");
        System.out.println(testFibo(55));
        System.out.println(testFibo(144));
        System.out.println(testFibo(120));
        System.out.println("Demo3: ");
        System.out.println(ap(6, 1.5, 2));
        System.out.println("Demo4: ");
        System.out.println(gp(6, 1.5, 2));
        System.out.println("Demo5: ");
        double a[] = {1.5, 2, 4, 5, 2, 6.5};
        System.out.println(sum(a, 6));
        System.out.println("Demo6: ");
        int b[] = {1, 5, 9, 7, 2, 19, 10};
        System.out.println(max(b, 7));
        System.out.println("Demo7: ");
        System.out.println(min(b, 7));
        System.out.println("Demo8: ");
        System.out.println("Binary: " + convert(266, 2));
        System.out.println("Decimal: " + convert(266, 10));
        System.out.println("Octal: " + convert(266, 8));
        System.out.println("Hexadecimal: " + convert(266, 16));
    }
}

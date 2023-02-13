
public class NewClass {

    public static int fun(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int t = fun(a, n / 2);
        if (n % 2 == 0) {
            return (t * t);
        } else {
            return (t * t * a);
        }
    }

    public static void quiz(int n) {
        if (n > 1) {
            quiz(n / 2);
            quiz(n / 2);
        }
        System.out.print("* \n");
    }

    public static int fun1(int n) {
        if (n < 0) {
            return fun1(-n);
        } else if (n < 5) {
            return (2);
        } else {
            return (n * fun1(n / 2));
        }
    }

    public static void fun3(int n) {
        if (n > 0) {
            fun3(n - 2);
            System.out.print(" " + n);
        }
    }

    public static void fun4(int n) {
        if (n == 1 || n == 2) {
            fun4(n) = 1;
        }
        if (n > 2) {
            fun4(n) = fun4(n - 1) + 2fun4(n - 2);
        }
    }
    public static void fun5(int n) {
        if (n == 0) {
            System.out.println("Hello");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print("$");
            }
            System.out.println();
            fun5(n - 1);
        }
    }
    public static void fun6(int n) {
        if (n > 0) {
            fun6(n - 2);
            System.out.print(" " + n);
        }
    }

    public static void main(String[] args) {
        System.out.println(fun(3, 2));
        quiz(5);
        System.out.println(fun1(-1012));
        fun3(9);
        System.out.println("\nfun5:");
        fun5(3);
        fun6(9);
    }
}

package demo4;

interface Square {

    int caculate(int x);

    default void print(int x) {
        System.out.println(x * x);
    }
}

public class Demo4 {

    public static void main(String[] args) {
        int n = 5;
        Square s = ((number) -> number * number);
        Square s1 = (x) -> {
            return x + x;
        };
        int ans = s.caculate(n);
        System.out.println(ans);
        ans = s1.caculate(n);
        System.out.println(ans);
    }

}

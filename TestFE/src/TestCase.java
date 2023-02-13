
import java.util.*;

public class TestCase {

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 6, 7, 8, 3, 4, 8, 6};
        int t = 1;
        int m = a[1];
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= m) {
                m = a[i];
                t = i;
            }
        }
        System.out.println(t);
    }
}

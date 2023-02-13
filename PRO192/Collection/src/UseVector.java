
import java.util.Vector;

class Point {

    int x, y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

public class UseVector {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(15);
        v.add("Hello");
        v.add(new Point());
        v.add(new Point(5, -7));
        System.out.println(v);
        v.remove(2);
        System.out.println(v);
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + ", ");
        }
        System.out.println();
    }
}


import java.util.*;

class Pen implements Comparable<Pen> {

    String color;
    int price;

    public Pen(String color, int price) {
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + color + "," + price + ")";
    }

    @Override
    public int compareTo(Pen x) {
        int k = color.compareTo(x.color);
        if (k != 0) {
            return (-k);
        }
        return (x.price - price);
//        return (price - x.price);
    }

}

public class Main {

    public static void main(String[] args) {
        List<Pen> t = new ArrayList<>();
        t.add(new Pen("B", 3));
        t.add(new Pen("C", 4));
        t.add(new Pen("D", 7));
        t.add(new Pen("C", 5));
        t.add(new Pen("A", 6));
        Collections.sort(t);
        for (Pen x : t) {
            System.out.print(x);
        }
        System.out.println();
    }
}

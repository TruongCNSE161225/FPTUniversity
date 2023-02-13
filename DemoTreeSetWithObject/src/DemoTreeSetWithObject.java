
import java.util.Set;
import java.util.TreeSet;

public class DemoTreeSetWithObject {

    public static void main(String[] args) {
        Set<Customer> list = new TreeSet();
        list.add(new Customer(3, "A"));
        list.add(new Customer(1, "B"));
        list.add(new Customer(2, "C"));
        list.add(new Customer(4, "D"));
        list.add(new Customer(2, "C"));
        for (Customer s : list) {
            System.out.println(s);
        }
    }
}

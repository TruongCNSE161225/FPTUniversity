
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class DemoHashSetWithObject {
    public static void main(String[] args) {
        Set<Employee> list = new HashSet();
        list.add(new Employee(3, "A"));
        list.add(new Employee(1, "B"));
        list.add(new Employee(2, "C"));
        list.add(new Employee(4, "D"));
        list.add(new Employee(2, "C"));
        for (Employee s : list) {
            System.out.println(s);
        }
        List<Employee> alEmp = new ArrayList<Employee>(list);
        System.out.println("***************");
        Collection.sort(alEmp);
        for (Object s : alEmp) {
            System.out.println(s);
        }
    }
}

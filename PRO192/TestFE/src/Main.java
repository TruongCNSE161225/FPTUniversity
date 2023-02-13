
import java.util.*;

class Employee {

    private String dob;

    public Employee(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        String[] t = dob.split("/");
        int m = Integer.parseInt(t[1]);
        int y = Integer.parseInt(t[2]);
        if (m < 6) {
            return (2021 - y);
        } else {
            return (2021 - y + 1);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(new Employee("11/06/2000").getAge());
    }
}


import java.util.*;

public class Employee {

    private String name;
    private int id;

    public Employee(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID:" + id + ",Name:" + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee emp = (Employee) obj;
        return emp.getId() == this.getId()
                && emp.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int compareTo(Object o) {
        Employee s = (Employee) o;
        if (id > s.getId()) {
            return 1;
        } else if (id == s.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}

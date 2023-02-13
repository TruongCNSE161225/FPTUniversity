package employees;

import java.lang.Comparable;

public class Employee implements Comparable {

    private String code;
    private String name;
    private int salary;

    public Employee(String code, String name, int salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.println("Code: " + this.code);
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
    }

    public int compareTo(Object emp) {
        return this.getCode().compareTo(((Employee) emp).getCode());
    }
}

package program_pkg;

import customer_pkg.Customer;
import employee_pkg.Employee;
import manager_pkg.Manager;

public class Program {

    public static void main(String[] args) {
        Manager admin = new Manager();
        Employee tom = new Employee("david@gmail.com", "Emp001", "123", "Tom");
        admin.addUserToList(tom);
        Customer david = new Customer("david@gmail.com", "Cus100", "456", "David");
        admin.addUserToList(david);
        System.out.println("*****User List*****");
        admin.printList();
        System.out.println("*****Login info*****");
        admin.showLoginStatus();
    }
}

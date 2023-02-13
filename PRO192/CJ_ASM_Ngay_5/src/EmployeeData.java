
import java.util.*;

public class EmployeeData {

    ArrayList empList = new ArrayList();

    void addEmployee() {
        String name, address, code;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the employee code: ");
        code = input.nextLine();
        System.out.print("Enter the name: ");
        name = input.nextLine();
        System.out.print("Enter the address: ");
        address = input.nextLine();
        EmployeeDetail emp = new EmployeeDetail(code.toUpperCase(), name, address);
        empList.add(emp);
    }

    void removeEmployee() {
        String searchCode;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the employee code: ");
        searchCode = input.nextLine();
        for (Object obj : empList) {
            EmployeeDetail emp = (EmployeeDetail) obj;
            if (emp.empCode.equals(searchCode.toUpperCase())) {
                empList.remove(emp);
                System.out.println("Employee code: " + searchCode + " removed.");
                return;
            }
        }
        System.out.println("Employee not found!!");
    }

    void findEmployee() {
        String searchCode;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the employee code: ");
        searchCode = input.nextLine();
        for (Object obj : empList) {
            EmployeeDetail emp = (EmployeeDetail) obj;
            if (emp.empCode.equals(searchCode.toUpperCase())) {
                System.out.println("Employee Details: ");
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee not found!!");
    }

    void printEmployeeList() {
        int i = 0;
        System.out.println("The size of list = " + empList.size());
        for (Object emp : empList) {
            System.out.printf("------Number %d------", ++i);
            System.out.println(emp);
        }
    }
}

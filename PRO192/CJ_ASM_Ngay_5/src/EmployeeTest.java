
import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {
        EmployeeData empData = new EmployeeData();
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\n!!!Welcome to My Company!!!\n" + "Select the operation you want to perform: ");
        do {
            System.out.println("******************************************");
            System.out.println("1. Add new employee");
            System.out.println("2. Display the employee details");
            System.out.println("3. Delete employee");
            System.out.println("4. Publish the entire list");
            System.out.println("5. Exit");
            System.out.println("******************************************");
            System.out.print("Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    empData.addEmployee();
                    break;
                case 2:
                    empData.findEmployee();
                    break;
                case 3:
                    empData.removeEmployee();
                    break;
                case 4:
                    empData.printEmployeeList();
                    break;
                case 5:
                    System.out.println("Good bye!!!");
                    break;
                default:
                    System.out.println("Not a valid choice!!!");

            }

        } while (choice != 5);

    }
}

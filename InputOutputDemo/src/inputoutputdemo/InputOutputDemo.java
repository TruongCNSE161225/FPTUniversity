package inputoutputdemo;
import java.util.Scanner;
public class InputOutputDemo {
    public static void main(String[] args) {
        int array[];
        int numberOfArray;
        int index;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        numberOfArray = Integer.parseInt(sc.nextLine());
        array = new int[numberOfArray];
        for (index=0;index<numberOfArray;index++){
            System.out.print("Enter the " + (index+1) + "/" + numberOfArray + " element: ");
            array[index]=Integer.parseInt(sc.nextLine());
        }
        System.out.print("Entered values: ");
        for (index=0;index<numberOfArray;index++) System.out.format("%5d", array[index]);
        int sum=0;
        for (int x: array) sum+=x;
        System.out.println("\nSum of values: " + sum);
    }
}
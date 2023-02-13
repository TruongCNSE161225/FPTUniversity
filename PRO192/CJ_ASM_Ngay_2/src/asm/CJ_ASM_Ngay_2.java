package asm;
import java.util.*;
public class CJ_ASM_Ngay_2 {
    static int Add(int firstNumber, int secondNumber){
        int result;
        result = firstNumber + secondNumber;
        return result;
    }
    public static void main(String[] args){
        int choice, firstNumber, secondNumber;
        double result = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Jva program");
        System.out.print("Enter the first number: ");
        firstNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the second number: ");
        secondNumber = Integer.parseInt(sc.nextLine());
        do{
            System.out.println("Select operation: ");
            System.out.println("1. Add");
            System.out.println("2. Sub");
            System.out.println("3. Mul");
            System.out.println("4. Div");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    result = firstNumber + secondNumber;
                    System.out.format("%d + %d = %.2f\n", firstNumber, secondNumber, result);
                    break;
                case 2:
                    result = firstNumber - secondNumber;
                    System.out.format("%d - %d = %.2f\n", firstNumber, secondNumber, result);
                    break;
                case 3:
                    result = firstNumber * secondNumber;
                    System.out.format("%d x %d = %.2f\n", firstNumber, secondNumber, result);
                    break;
                case 4:
                    if(secondNumber==0){
                        System.out.println("The second number is different 0!!!");
                    }
                    result = (double)firstNumber / secondNumber;
                    System.out.format("%d / %d = %.2f\n", firstNumber, secondNumber, result);
                    break;
                default:
                    System.out.println("Thank you . Goodbye.");
                    System.exit(0);
            }
        }
        while(true);
    }
}
public class Program {
    public static void main(String[] args) {
        Medicine med = new Medicine();
        med.Accept();
        med.IncreaseQuantity(50);
        System.out.println("Test the first Print() method");
        med.Print();
        System.out.println("\nTest the second Print() method");
        med.Print("code");
        System.out.println("\nTest the third Print() method");
        med.Print("code", "name");
    }
}

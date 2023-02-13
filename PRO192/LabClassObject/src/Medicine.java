import java.util.*;
public class Medicine {
    private String code;
    private String name;
    private String manufacturer;
    private int price;
    private int quantity;
    private String date;
    private String expireDate;
    private int batchNumber;
    public Medicine(){
        code = null;
        name = null;
        manufacturer = null;
        price = 0;
        quantity = 0;
        date = null;
        expireDate = null;
        batchNumber = 0;
    }
    public Medicine(String code, String name, String manufacturer,int price, int quantity, String date, String expireDate, int batchNumber){
        this.code = code;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.expireDate = expireDate;
        this.batchNumber = batchNumber;
    }
    public void Accept(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the medicine code: ");
        code = sc.nextLine();
        System.out.print("Enter the medicine name: ");
        name = sc.nextLine();
        System.out.print("Enter the manufacturer name: ");
        manufacturer = sc.nextLine();
        System.out.print("Enter the unit price: ");
        price = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the quantity on hand: ");
        quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the manufactured date: ");
        date = sc.nextLine();
        System.out.print("Enter the expiry date: ");
        expireDate = sc.nextLine();
        System.out.print("Enter the batch number: ");
        batchNumber = Integer.parseInt(sc.nextLine());
    }
    public void IncreaseQuantity(int number){
        quantity += number;
    }
    public void Print(){
        System.out.println("******* The Medicine Detail *******");
        System.out.println("Medicine code: "+ code);
        System.out.println("Medicine name: "+ name);
        System.out.println("Manufacturer name: "+ manufacturer);
        System.out.println("The unit price: "+ price);
        System.out.println("The quantity on hand: "+ quantity);
        System.out.println("The manufactured date: "+ date);
        System.out.println("The expiry date: "+ expireDate);
        System.out.println("The batch number: "+ batchNumber);
    }
    public void Print(String code){
        System.out.println("The medicine code: "+ code);
        System.out.println("The quantity on hand: "+ quantity);
    }
    public void Print(String code, String name){
        System.out.println("The medicine code: "+ code);
        System.out.println("The medicine name: "+ name);
        System.out.println("The expiry date: "+ expireDate);
        System.out.println("The manufactured date: "+ date);       
    }
}

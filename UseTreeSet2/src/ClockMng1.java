
import java.util.Scanner;
import tools.MyUtil;

public class ClockMng1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClockList list = new ClockList();
        list.add(new Clock("C009", "Nam HN", 120));
        list.add(new Clock("C003", "SG", 125));
        list.add(new Clock("C007", "STG", 70));
        list.add(new Clock("C001", "Seiko", 210));
        list.add(new Clock("C004", "Citizen", 180));
        list.output();
        String ID = "C333";
        Clock ck = list.search(ID);
        if (ck == null || !ck.getID().equals(ID)) {
            System.out.println("Clock " + ID + " does not exist");
        } else {
            System.out.println("Found: " + ck);
        }
        ID = "C009";
        ck = list.search(ID);
        if (ck == null || !ck.getID().equals(ID)) {
            System.out.println("Clock " + ID + " does not exist");
        } else {
            System.out.println("Found: " + ck);
        }
        Menu mainMenu = new Menu();
        mainMenu.add("Add clock");
        mainMenu.add("Search clock");
        mainMenu.add("Delete clock");
        mainMenu.add("Update clock");
        mainMenu.add("Display clock");
        ClockList mng = new ClockList();
        int choice;
        do {
            try {
                System.out.println("\n----------HOSPITAL MANAGEMENT----------");
                choice = mainMenu.getChoice();
                switch (choice) {
                    case 1:
                        String inID = MyUtil.readNonBlankStr("ID");
                        String manufacturer = MyUtil.readNonBlankStr("Manufacturer");
                        int price = MyUtil.readInt("Price", 0);
                        list.add(new Clock(inID, manufacturer, price));
                        break;
                    case 2:
                        inID = MyUtil.readNonBlankStr("ID");
                        ck = list.search(inID);
                        if (ck == null || !ck.getID().equals(inID)) {
                            System.out.println("Clock " + inID + " does not exist");
                        } else {
                            System.out.println("Found: " + ck);
                        }
                        break;
                    case 3:
                        inID = MyUtil.readNonBlankStr("ID");
                        inID.contains(ID);
                        list.remove(inID);
                        break;
                    case 4:
                        inID = MyUtil.readNonBlankStrUp("ID");
                        manufacturer = MyUtil.readNonBlankStrUp("Manufacturer");
                        price = MyUtil.readInt("Price", 0);
                        list.add(new Clock(inID, manufacturer, price));
                        break;
                    case 5:
                        list.output();
                        break;
                    default:
                        System.out.println("Goodbye!");
                }
            } catch (Exception e) {
                choice = 0;
                System.out.println("Error! Please run the program again!");
            }
        } while (choice > 0 && choice <= mainMenu.size());
    }
}

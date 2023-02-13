package items;

import java.util.Vector;
import java.util.Scanner; 

public class Menu extends Vector<String>{

    private int length;
    public Menu(){
        super();
    }
    void addMenuItem(String S){
        this.add(S);
    }
    public static int getUserChoice() {
        String [] options={"Add new item","Remove an item","Promoting the item's price","Print the list","Save to files","Quit"};
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.println("Choose 1..." + options.length + ": ");
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }
}

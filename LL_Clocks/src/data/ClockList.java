package data;

import java.util.LinkedList;
import tools.MyUtil;
import java.util.Scanner;

public class ClockList extends LinkedList<Clock> {

    static Scanner sc = MyUtil.sc;

    public ClockList() {
    }

    public void addClock() {
        int pos;
        String ID;
        do {
            ID = MyUtil.readPattern("Enter ID Cxxx", "C[\\d]{3}");
            pos = this.indexOf(new Clock(ID));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        int guaratee = MyUtil.readInt("Guarantee", 0, 6);
        double price = MyUtil.readDouble(ID, 0.0);
        Clock clk = new Clock(ID, guaratee, price);
        this.addLast(clk);
        System.out.println("A new clock is added.");
    }

    public void searchClock() {
        String ID = MyUtil.readPattern("Enter ID Cxxx", "C[\\d]{3}");
        int pos = this.indexOf(new Clock(ID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            System.out.println("Found: " + this.get(pos));
        }
    }

    public void removeClock() {
        String ID = MyUtil.readPattern("Enter ID Cxxx", "C[\\d]{3}");
        int pos = this.indexOf(new Clock(ID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            boolean res = MyUtil.readBool("Remove the clock. Really? ");
            if (res == true) {
                this.remove(pos);
                System.out.println("Removed.");
            }
        }
    }

    public void updateClock() {
        String ID = MyUtil.readPattern("Enter ID Cxxx", "C[\\d]{3}");
        int pos = this.indexOf(new Clock(ID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            Clock clk = this.get(pos);
            int oldGuarantee = clk.guarantee;
            double oldPrice = clk.price;
            String input;
            System.out.println("Update guarantee:");
            System.out.print("Old guarantee:" + oldGuarantee);
            System.out.print("\nNew guarantee:[Enter for bypassing: ");
            input = sc.nextLine().trim();
            if (input.length() > 0) {
                clk.setGuarantee(Integer.parseInt(input));
            }
            System.out.print("Old price:" + oldPrice);
            System.out.print("\nNew price:[Enter for bypassing: ");
            input = sc.nextLine().trim();
            if (input.length() > 0) {
                clk.setPrice(Double.parseDouble(input));
            }
            System.out.println("Updated.");
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Clock list");
            for (Clock clk : this) {
                System.out.println(clk);
            }
            System.out.println(this.size() + " clock(s).");
        }
    }

    public void printPriceRange() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        double p1, p2;
        p1 = MyUtil.readDouble("Low price", 0);
        p2 = MyUtil.readDouble("High price", 0);
        if (p1 > p2) {
            double t = p1;
            p1 = p2;
            p2 = t;
        }
        for (Clock clk : this) {
            double price = clk.price;
            if (price >= p1 && price <= p2) {
                System.out.println(clk);
            }
        }
    }
}

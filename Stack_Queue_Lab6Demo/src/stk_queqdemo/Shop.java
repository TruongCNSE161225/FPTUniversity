package stk_queqdemo;

import java.util.LinkedList;
import java.util.Random;

public class Shop {

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList();
        int duty = 30;
        Accountant acc = new Accountant(duty, queue);
        Thread accThread = new Thread(acc);
        accThread.start();
        int N = 10;
        Customer[] custList = new Customer[N];
        String custName;
        Random rand = Customer.rand;
        int delay;
        for (int i = 0; i < N; i++) {
            custName = "cust " + (i + 1);
            delay = 200 + rand.nextInt(500);
            custList[i] = new Customer(custName, delay, accThread, queue);
        }
        for (int i = 0; i < N; i++) {
            custList[i].start();
        }
    }
}

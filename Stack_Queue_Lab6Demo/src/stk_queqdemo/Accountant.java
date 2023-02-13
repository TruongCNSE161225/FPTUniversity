package stk_queqdemo;

import java.util.LinkedList;

public class Accountant implements Runnable {

    LinkedList<String> queue;
    int duty;
    int count = 0;

    public Accountant(int duty, LinkedList<String> queue) {
        this.duty = duty;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (count < duty) {
            try {
                if (!queue.isEmpty()) {
                    count++;
                    String invoiceInfo = "Invoive " + count + "/" + duty
                            + ": " + queue.removeFirst();
                    System.out.println(invoiceInfo);
                }
                if (count == duty) {
                    Thread.currentThread().yield();
                } else {
                    Thread.currentThread().sleep(500);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

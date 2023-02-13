/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xForest, int xRate, int xSound) {
        //You should write here appropriate statements to complete this function.
        if (xForest.charAt(0) == 'A') {
            return;
        }
        Boo boo = new Boo(xForest, xRate, xSound);
        Node node = new Node(boo);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Boo x, y;
        x = new Boo("X", 1, 2);
        y = new Boo("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node thirdElement = new Node(x, head.next);
        Node secondElement = new Node(y, thirdElement);
        head.next = secondElement;
        if (head == tail) {
            tail = thirdElement;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
//    Node delete(Node preNode, Node currentNode, Node nextNode) {
//        if (preNode == null) {
//            currentNode.next = null;
//        } else if (currentNode.next == null) {
//            preNode.next = null;
//            return null;
//        } else {
//            preNode.next = nextNode;
//            currentNode.next = null;
//        }
//        return nextNode;
//    }
    
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//        Node currentNode = this.head;
//        Node preNode = null;
//        int position = 0;
//        while (currentNode.next != null) {
//            position++;
//            if (position == 2 || position == 3) {
//                currentNode = delete(preNode, currentNode, currentNode.next);
//            } else {
//                preNode = currentNode;
//                currentNode = currentNode.next;
//            }
//        }
        Node firstElement = head;
        firstElement.next = firstElement.next.next.next;
        if (firstElement == null) {
            tail = head;
        }
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node currentElement = head;
        Node nextElement = null;
        Node stop = head.next.next.next.next.next;
        Boo tmp;
        while (currentElement != stop) {
            nextElement = currentElement.next;
            while (nextElement != stop) {
                if (nextElement.info.sound < currentElement.info.sound) {
                    tmp = currentElement.info;
                    currentElement.info = nextElement.info;
                    nextElement.info = tmp;
                }
                nextElement = nextElement.next;
            }
            currentElement = currentElement.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}

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
    void addLast(Boo x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addLast(String xForest, int xRate, int xSound) {
        //You should write here appropriate statements to complete this function.
        if (xForest.charAt(0) == 'A') {
            return;
        }
        Boo x = new Boo(xForest, xRate, xSound);
        addLast(x);
    }

    public void insert(Boo x, int position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }
        int count = 1;
        Node p = head;
        while (p != null && count < position) {
            p = p.next;
            count++;
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }

    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

    public void delete(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    public void sort() {
        Node pi, pj;
        pi = head;
        int count = 0;
        while (pi != null) {
            count++;
            pj = pi.next;
            int count1 = 0;
            while (pj != null) {
                count1++;
                if (pi.info.sound > pj.info.sound) {
                    Boo t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
                pj = pj.next;
                if (count1 == 5 - count) {
                    break;
                }
            }
            pi = pi.next;
            if (count == 4) {
                break;
            }
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
        insert(y, 1);
        insert(x, 2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
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
        delete(1);
        delete(1);
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
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}

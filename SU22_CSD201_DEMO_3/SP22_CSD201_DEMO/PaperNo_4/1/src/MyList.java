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
        char charFilter = 'A';
        Node newNode = new Node(new Boo(xForest, xRate, xSound));
        if (xForest.charAt(0) == charFilter) {
            return;
        }
        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
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
        Node currentNode = this.head;
        int position = 0;
        while (currentNode.next != null) {
            position++;
            if (position == 1) {
                Node nextNode = currentNode.next;
                currentNode.next = new Node(y, new Node(x, nextNode)); // add new Node
            }
            currentNode = currentNode.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
     Node remove(Node preNode, Node currentNode, Node nextNode) {
        if (preNode == null) {
            currentNode.next = null;
        } else if (currentNode.next == null) {
            preNode.next = null;
            return null;
        } else {
            preNode.next = nextNode;
            currentNode.next = null;
        }
        return nextNode;
    }
     
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
        Node currentNode = this.head;
        Node preNode = null;
        int position = 0;
        while (currentNode.next != null) {
            position++;
            if (position == 2 || position == 3) {
                currentNode = remove(preNode, currentNode, currentNode.next);
            } else {
                preNode = currentNode;
                currentNode = currentNode.next;
            }
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
         int amountFirstElements = 5;
        ArrayList<Node> listFirstElement = new ArrayList();
        Node currentNode = this.head;
        Node nextNode = null;
        int position = 0;
        //find first elements
        while (currentNode.next != null) {
            position++;
            if (position <= amountFirstElements) {
                listFirstElement.add(currentNode);
                if (position == amountFirstElements) {
                    nextNode = currentNode.next;
                    break;
                }
            }
            currentNode = currentNode.next;
        }
        //Sorting
        listFirstElement.sort((c1, c2) -> {
            int value1 = c1.info.sound;
            int value2 = c2.info.sound;
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
            return 0;
        });
        //link firstElementList to LinkedList
        for (int i = 0; i < listFirstElement.size() - 1; i++) {
            Node cNode = listFirstElement.get(i);
            cNode.next = listFirstElement.get(i + 1);
            if (i == 0) {
                head = cNode;
            }
            if (i == listFirstElement.size() - 2) {
                cNode.next.next = nextNode;
            }
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}

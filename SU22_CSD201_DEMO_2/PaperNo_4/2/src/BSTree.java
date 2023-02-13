/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xForest, int xRate, int xSound) {
        //You should insert here statements to complete this function
        if (xForest.charAt(0) == 'A') {
            return;
        }
        Boo boo = new Boo(xForest, xRate, xSound);
        if (isEmpty()) {
            root = new Node(boo);
            return;
        }
        Node f = null;
        Node p = root;
        while (p != null) {
            if (p.info.sound == xSound) {
                return;
            }
            f = p;
            if (xSound < p.info.sound) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (xSound < f.info.sound) {
            f.left = new Node(boo);
        } else {
            f.right = new Node(boo);
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
//    void preOrder(Node p, RandomAccessFile f) throws Exception {
//        if (p == null) {
//            return;
//        }
//        fvisit(p, f);
//        preOrder(p.left, f);
//        preOrder(p.right, f);
//    }
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.rate < 6) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrder3(ArrayList<Boo> t, Node p) {
        if (p == null) {
            return;
        }
        t.add(p.info);
        preOrder3(t, p.left);
        preOrder3(t, p.right);
    }

    void deleteNodeByCopying(Boo x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x.sound < p.info.sound) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
                return;
            }
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
                return;
            }
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
                return;
            }
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        ArrayList<Boo> t = new ArrayList<>();
        preOrder3(t, root);
        Boo p = t.get(3);
        deleteNodeByCopying(p);
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrder4(ArrayList<Boo> t, Node p) {
        if (p == null) {
            return;
        }
        t.add(p.info);
        preOrder4(t, p.left);
        preOrder4(t, p.right);
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        Node f, s;
        f = null;
        s = root;
        while (s != null) {
            if (s == p) {
                break;
            }
            f = s;
            if (p.info.sound > s.info.sound) {
                s = s.right;
            } else {
                s = s.left;
            }
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        if (f == null) {
            root = q;
        }
        if (f.left == p) {
            f.left = q;
        }
        if (f.right == p) {
            f.right = q;
        }
        return (q);
    }

//    Node rotateRight(Node p) {
//        if (p == null || p.left == null) {
//            return (p);
//        }
//
//        Node f, s;
//        f = null;
//        s = root;
//        while (s != null) {
//            if (s == p) {
//                break;
//            }
//            f = s;
//            if (p.info.sound < s.info.sound) {
//                s = s.left;
//            } else {
//                s = s.right;
//            }
//        }
//
//        Node q = p.left;
//        p.left = q.right;
//        q.right = p;
//        if (f == null) {
//            root = q;
//        }
//        if (f.right == p) {
//            f.right = q;
//        }
//        if (f.left == p) {
//            f.left = q;
//        }
//        return (q);
//    }
    
    public Node search(Node p, Boo x) {
        if (p == null) {
            return null;
        }
        if (p.info.sound == x.sound) {
            return p;
        } else if (x.sound < p.info.sound) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        ArrayList<Boo> t = new ArrayList<>();
        preOrder4(t, root);
        Boo p = t.get(3);
        rotateLeft(search(root, p));
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
}

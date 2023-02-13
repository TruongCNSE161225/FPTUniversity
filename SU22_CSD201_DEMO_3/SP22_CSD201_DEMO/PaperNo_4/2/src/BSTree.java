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
        if (xForest.charAt(0) != 'B') {
            if (root == null) {
                root = new Node(new Boo(xForest, xRate, xSound));
            } else {
                int level = 1;
                Node cNode = root;
                while (cNode != null) {
                    level++;
                    if (xRate > cNode.info.rate) { // Note key of tree can change 
                        if (cNode.right == null) {
                            cNode.right = new Node(new Boo(xForest, xRate, xSound));
                            cNode.right.level = level;
                            break;
                        }
                        cNode = cNode.right;
                    } else if (xRate < cNode.info.rate) {
                        if (cNode.left == null) {
                            cNode.left = new Node(new Boo(xForest, xRate, xSound));
                            cNode.left.level = level;
                            break;
                        }
                        cNode = cNode.left;
                    } else {
                        return;
                    }
                }
            }
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
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.sound < 6) { // condition visited
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
    int countChild(Node parent
    ) {
        if (parent.left == null && parent.right == null) {
            return 0;
        }
        if ((parent.left != null && parent.right == null)
                || (parent.left == null && parent.right != null)) {
            return 1;
        }
        return 2;
    }

    Node deleteLeaf(Node parent, Node dChild
    ) {
        if (dChild == root) {
            root = null;
        }
        if (parent.left == dChild) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        return dChild;
    }

    Node delete1ChildNode(Node parent, Node dChild
    ) {
        if (dChild == root) {
            root = root.left != null ? root.left : root.right;
        }
        Node grandChild;
        if (dChild.left != null) {
            grandChild = dChild.left;
        } else {
            grandChild = dChild.right;
        }
        if (parent.left == dChild) {
            parent.left = grandChild;
        } else {
            parent.right = grandChild;
        }
        return dChild;
    }

    Node delete2ChildNode(Node dNode
    ) {
        Node father = dNode;
        Node rightMost = dNode.left;
        while (rightMost.right != null) {
            father = rightMost;
            rightMost = rightMost.right;
        }
        dNode.info = rightMost.info;
        //remove right most
        int count = countChild(rightMost);
        if (count == 1) {
            return delete1ChildNode(father, rightMost);
        }
        return deleteLeaf(father, rightMost);
    }

    void deleteNode(Node dNode
    ) {
        Node parent = null;
        Node cNode = root;
        while (cNode != null) {
            int cValue = cNode.info.rate;// key of tree
            int dValue = dNode.info.rate;//
            if (cValue == dValue) {
                break;
            } else {
                parent = cNode;
                if (cValue > dValue) {
                    cNode = cNode.left;
                } else if (cValue < dValue) {
                    cNode = cNode.right;
                }
            }
        }
        int countChild = countChild(dNode);
        if (countChild == 0) {
            deleteLeaf(parent, dNode);
            return;
        }
        if (countChild == 1) {
            delete1ChildNode(parent, dNode);
            return;
        }
        delete2ChildNode(dNode);

    }

    void preOrder3(Node p, ArrayList arr) throws Exception {
        if (p == null) {
            return;
        }
        arr.add(p);
        preOrder3(p.left, arr);
        preOrder3(p.right, arr);
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
        int detelePosition = 4; // delete index
        ArrayList<Node> list = new ArrayList();
        //load data to arr to find element at index deletePosition -1
        preOrder3(root, list);
        deleteNode(list.get(detelePosition - 1));
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node rightMost(Node node
    ) {
        Node rightChildNode = node;
        while (rightChildNode.right != null) {
            rightChildNode = rightChildNode.right;
        }
        return rightChildNode;
    }

    void rotateToRightOfLeftChild(Node parentNode, Node rNode
    ) {
        Node leftChild = rNode.left;
        rNode.left = null; // remove child 
        // set child into new position
        if (parentNode.right == rNode) {
            parentNode.right = leftChild;
        } else {
            parentNode.left = leftChild;
        }
        Node rightMostNodeOfChild = rightMost(leftChild);
        rightMostNodeOfChild.right = rNode;
    }

    Node leftMost(Node node
    ) {
        Node leftChildNode = node;
        while (leftChildNode.left != null) {
            leftChildNode = leftChildNode.left;
        }
        return leftChildNode;
    }

    void rotateToLeftOfRightChild(Node parentNode, Node rNode
    ) {
        Node rightChild = rNode.right;
        rNode.right = null; // remove child 
        // set child into new position
        if (parentNode.right == rNode) {
            parentNode.right = rightChild;
        } else {
            parentNode.left = rightChild;
        }
        Node rightMostNodeOfChild = leftMost(rightChild);
        rightMostNodeOfChild.left = rNode;
    }

    void rotateIntoChild(Node parent, Node rNode,
            String mode
    ) {

        if (mode.equalsIgnoreCase("rightChild")) {
            if (rNode.right == null) {
                return;
            }
            rotateToLeftOfRightChild(parent, rNode);
        } else if (mode.equalsIgnoreCase("leftChild")) {
            if (rNode.left == null) {
                return;
            }
            rotateToRightOfLeftChild(parent, rNode);
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
        int rotatePosition = 4; // position rotate node
        int index = rotatePosition - 1;
        ArrayList<Node> list = new ArrayList();
        preOrder3(root, list);
        Node parent = null;
        for (Node node : list) {
            if (node.left == list.get(index)
                    || node.right == list.get(index)) {
                parent = node;
                break;
            }
        }
        String mode = "leftChild"; // leftChild or rightChild
        rotateIntoChild(parent, list.get(index), mode);
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}


public class BST {

    BST_Node root;
    int noOfNodes = 0;

    public BST() {
        root = null;
    }

    public BST_Node add_recur(BST_Node curref, Comparable data) {
        if (curref == null) {
            curref = new BST_Node(data);
            noOfNodes++;
        } else if (data.compareTo(curref.data) < 0) {
            curref.left = add_recur(curref.left, data);
        } else {
            curref.right = add_recur(curref.right, data);
        }
        return curref;
    }

    public void add_recur(Comparable data) {
        root = add_recur(root, data);
    }

    public void add_recur(Comparable... group) {
        for (Comparable data : group) {
            add_recur(data);
        }
    }

    public void add_Array(Comparable[] group) {
        for (Comparable data : group) {
            add_recur(data);
        }
    }

    private void printAligned(BST_Node p, int nSpace) {
        if (p != null) {
            for (int i = 0; i < nSpace; i++) {
                System.out.print(" ");
            }
            System.out.println(p.data);
            printAligned(p.left, nSpace + 3);
            printAligned(p.right, nSpace + 3);
        }
    }

    public void printAligned() {
        if (root == null) {
            System.out.println("Empty tree!");
        } else {
            printAligned(root, 0);
        }
    }

    public void rotateRight(BST_Node Gr, BST_Node Par, BST_Node Ch) {
        if (Par == root) {
            root = Ch;
        } else {
            Gr.right = Ch;
        }
        Par.left = Ch.right;
        Ch.right = Par;
    }

    void createBackbone() {
        BST_Node Gr = null, Par = root, leftChild;
        while (Par != null) {
            while (Par.left != null) {
                leftChild = Par.left;
                rotateRight(Gr, Par, leftChild);
                Par = leftChild;
            }
            Gr = (Gr == null) ? root : Gr.right;
            Par = Par.right;
        }
    }

    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    private int heightPerfectBalancedTree(int noOfNodes) {
        return (int) log2(noOfNodes + 1);
    }

    private int sizeOfPerfectBalancedTree(int H) {
        return (int) (Math.pow(2, H) - 1);
    }

    public void rotateLeft(BST_Node Gr, BST_Node Par, BST_Node Ch) {
        if (Par == root) {
            root = Ch;
        } else {
            Gr.right = Ch;
        }
        Par.right = Ch.left;
        Ch.left = Par;
    }

    void createBalancedTree() {
        int H = heightPerfectBalancedTree(noOfNodes);
        int perfectSize = sizeOfPerfectBalancedTree(H);
        int extraNodes = noOfNodes - perfectSize;
        BST_Node Gr = null, Par = root, rightChild = Par.right;
        for (int i = 0; i < extraNodes; i++) {
            rotateLeft(Gr, Par, rightChild);
            Gr = rightChild;
            Par = Gr.right;
            if (Par != null) {
                rightChild = Par.right;
            } else {
                rightChild = null;
            }
        }
        Gr = root;
        while (perfectSize > 1) {
            perfectSize /= 2;
            Gr = null;
            Par = root;
            rightChild = Par.right;
            for (int i = 0; i < perfectSize; i++) {
                rotateLeft(Gr, Par, rightChild);
                Gr = rightChild;
                Par = Gr.right;
                if (Par != null) {
                    rightChild = Par.right;
                } else {
                    rightChild = null;
                }
            }
        }
    }

    public void DSW_Balance() {
        if (root != null) {
            createBackbone();
            createBalancedTree();
        }
    }
}

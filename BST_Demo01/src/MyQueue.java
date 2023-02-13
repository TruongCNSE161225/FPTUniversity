
import java.util.LinkedList;

public class MyQueue {

    LinkedList<BST_Node> L;

    public MyQueue() {
        L = new LinkedList();
    }

    public boolean isEmpty() {
        return L.isEmpty();
    }

    public void enqueue(BST_Node node) {
        L.addLast(node);
    }

    public BST_Node dequeue() {
        return L.removeFirst();
    }
}

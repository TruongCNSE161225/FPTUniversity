
import java.util.LinkedList;

public class MyQueue {

    LinkedList<Integer> t;

    public MyQueue() {
        t = new LinkedList();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(int x) {
        t.add(x);
    }

    int dequeue() {
        return (t.removeFirst());
    }
}

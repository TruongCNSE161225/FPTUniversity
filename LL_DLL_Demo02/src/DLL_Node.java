
public class DLL_Node {

    Flower flower;
    DLL_Node next;
    DLL_Node previous;

    public DLL_Node(Flower f) {
        this.flower = f;
        next = previous = null;
    }

    public DLL_Node(String name, String original, int price) {
        this(new Flower(name, original, price));
    }
}

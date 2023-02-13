
public class SLL_Node {

    SoftDrink data;
    SLL_Node next;

    public SLL_Node(SoftDrink aSD) {
        this.data = aSD;
        next = null;
    }

    public SLL_Node(String productLine, String company, int volume, int price) {
        SoftDrink aSD = new SoftDrink(productLine, company, volume, price);
        this.data = aSD;
        next = null;
    }
}

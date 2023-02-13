
public class SpecCala extends Cala {

    private int color;

    public SpecCala() {
    }

    public SpecCala(int color, String owner, int price) {
        super(owner, price);
        this.color = color;
    }

    public String toString() {
        return super.getOwner() + ", " + super.getPrice() + ", " + this.color;
    }
//Replace 2nd character in owner with the string "XX"
    public void setData() {
        String[] tmp = super.getOwner().split("");
        tmp[1] = "XX";
        String tmp2 = "";
        for (int i = 0; i < super.getOwner().length(); i++) {
            tmp2 += tmp[i];
        }
        super.setOwner(tmp2);
    }
//Check if color is odd number then return price + 3, otherwise return price + 7
    public int getValue() {
        if (this.color % 2 == 0) {
            return super.getPrice() + 7;
        } else {
            return super.getPrice() + 3;
        }
    }
}


public class SpecCar extends Car {

    private int type;

    public SpecCar() {
    }

    public SpecCar(String maker, int price, int type) {
        super(maker, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.getMaker() + ", " + super.getPrice() + ", " + this.type;
    }
//Add string "XZ" to the head of maker and increase price by 20.
    public void setData() {
        super.setMaker("XZ" + super.getMaker());
        super.setPrice(super.getPrice() + 20);
    }
//Return price + inc, where if type <7 then inc=10, otherwise inc=15.
    public int getValue() {
        int inc;
        if (this.type < 7) {
            inc = 10;
        } else {
            inc = 15;
        }
        return super.getPrice() + inc;
    }
}

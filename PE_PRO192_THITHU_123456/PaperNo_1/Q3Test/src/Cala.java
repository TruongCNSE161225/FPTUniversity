
public class Cala implements Comparable<Cala> {

    private String owner;
    private int price;

    public Cala() {
    }

    public Cala(String owner, int price) {
        this.owner = owner;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Cala o) {
        if (o.getOwner().charAt(1) > owner.charAt(1)) {
            return -1;
        } else if (o.getOwner().charAt(1) < owner.charAt(1)) {
            return 1;
        } else {
            return 0;
        }
    }

}

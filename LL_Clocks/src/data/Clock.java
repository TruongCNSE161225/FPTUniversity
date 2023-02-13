package data;

import java.util.Objects;

public class Clock implements Comparable<Clock> {

    String ID;
    int guarantee = 0;
    double price = 0.0;

    public Clock(String ID, int guarantee, double price) {
        this.ID = ID;
        this.guarantee = guarantee;
        this.price = price;
    }

    public Clock(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object obj) {
        Clock clk = (Clock) obj;
        return this.ID.equals(clk.ID);
    }

    @Override
    public int compareTo(Clock o) {
        double d = this.price - o.price;
        return d > 0 ? 1 : d < 0 ? -1 : ID.compareTo(o.ID);
    }

    @Override
    public String toString() {
        return ID + ", " + guarantee + ", " + price;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

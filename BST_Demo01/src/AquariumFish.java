
public class AquariumFish implements Comparable<AquariumFish> {

    String name;
    int rate = 0;
    int price = 0;

    public AquariumFish(String name) {
        this.name = name;
    }

    public AquariumFish(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    @Override
    public int compareTo(AquariumFish o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + ", " + rate + ", " + price;
    }
}


class Van {

    String driver;
    int rate;

    public Van() {
        driver = "unknown";
        rate = 5;
    }

    public Van(String driver, int rate) {
        this.driver = driver;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return (driver + "," + rate);
    }

}

class SpecVan extends Van {

    int type;

    public SpecVan() {
    }

    public SpecVan(String driver, int rate, int type) {
        super(driver, rate);
        this.type = type;
    }

    void display() {
        String s = "(" + super.toString() + "," + type + ")";
        System.out.println(s);
    }
}

public class Main2 {

    public static void main(String[] args) {
        SpecVan x = new SpecVan();
        SpecVan y = new SpecVan("Hoa", 20, 10);
        x.display();
        y.display();
        System.out.println();
    }
}

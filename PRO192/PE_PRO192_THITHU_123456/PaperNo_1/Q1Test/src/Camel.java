
public class Camel {

    private String desert;
    private int step;

    public Camel() {
    }

    public Camel(String desert, int step) {
        this.desert = desert;
        this.step = step;
    }

    public String getDesert() {
        return desert.toUpperCase();
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}

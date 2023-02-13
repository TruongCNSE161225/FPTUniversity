
import java.io.FileReader;
import java.util.HashMap;

public class CharCounter extends HashMap<Integer, Integer> {

    int numOfChars = 0;

    public CharCounter() {
        super();
    }

    public CharCounter(String filename) {
        super();
        try {
            FileReader fr = new FileReader(filename);
            int code;
            while ((code = fr.read()) != -1) {
                if (!this.containsKey(code)) {
                    this.put(code, 1);
                } else {
                    this.replace(code, this.get(code) + 1);
                }
                numOfChars++;
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void print() {
        for (Integer cObj : this.keySet()) {
            System.out.println((char) cObj.intValue() + ", " + this.get(cObj) + ", " + 1.0 * this.get(cObj) / numOfChars);
        }
    }

    public static void main(String[] args) {
        CharCounter counter = new CharCounter("laychong.txt");
        counter.print();
    }
}

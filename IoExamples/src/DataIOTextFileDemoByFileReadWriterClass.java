
import java.io.*;

public class DataIOTextFileDemoByFileReadWriterClass {

    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write("Hello world");
            output.newLine();
            output.write("Java SE");
            output.close();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

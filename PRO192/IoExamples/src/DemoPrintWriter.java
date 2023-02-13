
import java.io.*;

public class DemoPrintWriter {

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("File name: ");
            String filename = in.readLine();
            PrintWriter out = new PrintWriter(new FileWriter(filename));
            System.out.println("Enter some wordings : [Enter 'stop' to quit]");
            String textLine = in.readLine();
            while (!textLine.equals("stop")) {
                out.println(textLine);
                textLine = in.readLine();
            }
            out.close();
            in.close();
        } catch (IOException error) {
            System.err.println("Error making file:");
            System.err.println("\t" + error);
        }
    }
}


import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoObjectInputOutputStream {

    public static void main(String[] args) {
        String s = "Hello World";
        byte[] b = {'E', 'x', 'a', 'm', 'p', 'l', 'e'};
        try {
            String fileName = "data.bin";
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(s);
            oout.writeObject(b);
            oout.flush();
            FileInputStream in = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(in);
            System.out.println("" + (String) ois.readObject());
            byte[] read = (byte[]) ois.readObject();
            String s2 = new String(read);
            System.out.println("" + s2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

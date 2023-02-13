
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SalePerson implements Serializable {

    String lastName;
    String firstName;
    double sal;
}

public class DemoObjectInputOutputStreamSerializationSingleObject {

    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileOutputStream fOut = null;
        ObjectInputStream oIn = null;
        ObjectOutputStream oOut = null;
        try {
            String fileName = "Saleperson.bin";
            fOut = new FileOutputStream(fileName);
            oOut = new ObjectOutputStream(fOut);
            SalePerson e = new SalePerson();
            e.lastName = "Smith";
            e.firstName = "John";
            e.sal = 5000.0;
            oOut.writeObject(e);
            oOut.close();
            fOut.close();
            fIn = new FileInputStream(fileName);
            oIn = new ObjectInputStream(fIn);
            SalePerson emp = (SalePerson) oIn.readObject();
            System.out.println("First Name :" + emp.firstName);
            System.out.println("Last Name :" + emp.lastName);
            System.out.println("Salary :" + emp.sal);

            fIn.close();
            oIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

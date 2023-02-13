package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PatientList extends ArrayList<Patient> {

    public void loadFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "|");
                String patientID = stk.nextToken();
                String patientName = stk.nextToken();
                int age = Integer.parseInt(stk.nextToken());
                String address = stk.nextToken();
                Patient newPatient = new Patient(patientID, patientName, age, address);
                this.add(newPatient);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeToFile(String fName) {
        if (this.size() == 0) {
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Patient p : this) {
                pw.println(p.getPatientID() + "|" + p.getPatientName() + "|" + p.getAge() + "|" + p.getAddress());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

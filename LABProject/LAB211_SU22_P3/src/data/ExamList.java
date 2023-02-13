package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import tools.MyUtil;

public class ExamList extends ArrayList<Examination> {

    String examID;
    String doctorID;
    String patientID;
    String result;
    Date date;

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
                examID = stk.nextToken().trim();
                doctorID = stk.nextToken().trim();
                patientID = stk.nextToken().trim();
                result = null;
                if (!result.equalsIgnoreCase(null)) {
                    result = stk.nextToken().trim();
                }
                SimpleDateFormat fomater = new SimpleDateFormat("dd-MM-yyyy");
                String dateStr = stk.nextToken().trim();
                date = null;
                if (!dateStr.equalsIgnoreCase("null")) {
                    date = fomater.parse(dateStr);
                }
                Examination newExam = new Examination(examID, doctorID, patientID, result, date);
                this.add(newExam);
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
            for (Examination e : this) {
                pw.println(e.getExamID() + "|" + e.getDoctorID() + "|" + e.getPatientID() + "|" + (e.getResult() == null ? "not update yet" : e.getResult()) + "|" + (e.getDate() == null ? "not update yet" : MyUtil.convertDateFormat(e.getDate())));
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

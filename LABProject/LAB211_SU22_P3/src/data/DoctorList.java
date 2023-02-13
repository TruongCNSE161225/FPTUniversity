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

public class DoctorList extends ArrayList<Doctor> {
    
    String doctorID;
    String doctorName;
    boolean sex;
    String address;
    String depID;
    Date createDate;
    Date lastUpdateDate;

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
                doctorID = stk.nextToken().toUpperCase();
                doctorName = stk.nextToken();
                char sexChar = stk.nextToken().trim().toUpperCase().charAt(0);
                sex = sexChar == '1';
                address = stk.nextToken();
                depID = stk.nextToken();
                SimpleDateFormat fomater = new SimpleDateFormat("dd-MM-yyyy");
                String createDateStr = stk.nextToken().trim();
                String lastUpdateDateStr = stk.nextToken().trim();
                createDate = null;
                lastUpdateDate = null;
                if (!createDateStr.equalsIgnoreCase("null")) {
                    createDate = fomater.parse(createDateStr);
                }
                if (!lastUpdateDateStr.equalsIgnoreCase("null")) {
                    lastUpdateDate = fomater.parse(lastUpdateDateStr);
                }
                Doctor newDoctor = new Doctor(doctorID, doctorName, sex, address, depID, createDate, lastUpdateDate);
                this.add(newDoctor);
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
            for (Doctor d : this) {
                pw.println(d.getDoctorID() + "|" + d.getDoctorName() + "|" + (d.isSex() == true ? "male" : "female") + "|" + d.getAddress() + "|"
                        + d.getDepID() + "|" + MyUtil.convertDateFormat(d.getCreateDate()) + "|" + (d.getLastUpdateDate() == null ? "not update yet" : MyUtil.convertDateFormat(d.getLastUpdateDate())));
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean containsDoctor(String depID) {
        for (Doctor d : this) {
            if (d.depID.equals(depID)) {
                return true;
            }
        }
        return false;
    }
}

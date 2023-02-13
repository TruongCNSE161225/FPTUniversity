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

public class DepList extends ArrayList<Department> {
    
    String depID;
    String depName;
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
                depID = stk.nextToken().toUpperCase();
                depName = stk.nextToken();
                String createDateStr = stk.nextToken().trim();
                String lastUpdateDateStr = stk.nextToken().trim();
                createDate = null;
                lastUpdateDate = null;
                SimpleDateFormat fomater = new SimpleDateFormat("dd-mm-yyyy");
                if (!createDateStr.equalsIgnoreCase("null")) {
                    createDate = fomater.parse(createDateStr);
                }
                if (!lastUpdateDateStr.equalsIgnoreCase("null")) {
                    lastUpdateDate = fomater.parse(lastUpdateDateStr);
                }
                Department newDept = new Department(depID, depName, createDate, lastUpdateDate);
                this.add(newDept);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeToFile(String fName) {
        if (this.isEmpty()) {
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Department d : this) {
                pw.println(d.getDepID() + "|" + d.getDepName() + "|"
                        + MyUtil.convertDateFormat(d.getCreateDate()) + "|" + (d.getLastUpdateDate() == null ? "not update yet" : MyUtil.convertDateFormat(d.getLastUpdateDate())));
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

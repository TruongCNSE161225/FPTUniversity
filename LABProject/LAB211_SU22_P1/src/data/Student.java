package data;

import java.util.Date;
import tools.MyUtil;

public class Student {

    public String stID;
    String fName = null;
    String lName = null;
    boolean gender = true;
    Date bDate = null;
    String email = null;
    String phone = null;

    public Student(String stID, String fName, String lName, boolean gender, Date bDate, String email, String phone) {
        this.stID = stID;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDate = bDate;
        this.email = email;
        this.phone = phone;
    }

    public Student(String stID) {
        this.stID = stID;
    }

    @Override
    public boolean equals(Object obj) {
        return stID.equals(((Student) obj).stID);
    }

    @Override
    public String toString() {
        return stID + ", " + fName + " " + lName + ", "
                + (gender == true ? " male, " : "female, ") + MyUtil.StrDMY(bDate)
                + ", " + email + ", " + phone;
    }

    public String getStID() {
        return stID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public boolean isGender() {
        return gender;
    }

    public Date getbDate() {
        return bDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

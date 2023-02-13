package data;

import java.util.Date;
import tools.MyUtil;

public class Doctor {

    String doctorID;
    String doctorName;
    boolean sex;
    String address;
    String depID;
    Date createDate;
    Date lastUpdateDate;

    public Doctor(String doctorID, String doctorName, boolean sex, String address, String depID, Date createDate, Date lastUpdateDate) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.depID = depID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Doctor(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object obj) {
        return doctorID.equals((((Doctor) obj).doctorID));
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorID + ", " + "doctor name: " + doctorName + ", " + "sex: " + (sex == true ? "male, " : "female, ")
                + "address: " + address + ", " + "department ID: " + depID + ", " + "create date: " + MyUtil.convertDateFormat(createDate) + ", " + "last update date: " + (lastUpdateDate == null ? "not update yet" : MyUtil.convertDateFormat(lastUpdateDate));
    }
}

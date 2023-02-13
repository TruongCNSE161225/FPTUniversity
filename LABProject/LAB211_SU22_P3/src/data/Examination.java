package data;

import java.util.Date;
import tools.MyUtil;

public class Examination {

    String examID;
    String doctorID;
    String patientID;
    String result;
    Date date;

    public Examination(String examID, String doctorID, String patientID, String result, Date date) {
        this.examID = examID;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.result = result;
        this.date = date;
    }

    public Examination(String examID) {
        this.examID = examID;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        return examID.equals((((Examination) obj).examID));
    }

    @Override
    public String toString() {
        return "Examination ID: " + examID + ", " + "doctor ID: " + doctorID + ", " + "patient ID: " + patientID + ", " + "result: " + (result == null ? "not update yet" : result) + ", " + "date: " + (date == null ? "not update yet" : MyUtil.convertDateFormat(date));
    }
}

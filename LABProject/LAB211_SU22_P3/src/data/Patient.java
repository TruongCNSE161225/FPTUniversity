package data;

public class Patient {

    String patientID;
    String patientName;
    int age;
    String address;

    public Patient(String patientID, String patientName, int age, String address) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.address = address;
    }

    public Patient(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return patientID.equals((((Patient) obj).patientID));
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientID + ", " + "patient name: " + patientName + ", " + "age: " + age + ", " + "address: " + address;
    }
}

package data;

public class Subject {

    public String subID;
    public String subName;
    int credit;

    public Subject(String subID, String subName, int credit) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
    }

    public Subject(String subID) {
        this.subID = subID;
    }

    @Override
    public boolean equals(Object obj) {
        return subID.equals(((Subject) obj).subID);
    }

    @Override
    public String toString() {
        return "Subject ID: " + subID + ", subject name: " + subName + ", credit: " + credit;
    }

    public String getSubID() {
        return subID;
    }

    public String getSubName() {
        return subName;
    }

    public int getCredit() {
        return credit;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setCredit(int credit) {
        if (credit > 0) {
            this.credit = credit;
        }
    }
}

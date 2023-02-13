package data;

import java.util.Date;
import tools.MyUtil;

public class Department {

    String depID;
    String depName;
    Date createDate;
    Date lastUpdateDate;

    public Department(String depID, String depName, Date createDate, Date lastUpdateDate) {
        this.depID = depID;
        this.depName = depName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Department(String depID) {
        this.depID = depID;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
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
        return depID.equals((((Department) obj).depID));
    }

    @Override
    public String toString() {
        return "Department ID: " + depID + ", " + "department name: " + depName + ", "
                + "create date: " + MyUtil.convertDateFormat(createDate) + ", " + "last update date: " + (lastUpdateDate == null ? "not update yet" : MyUtil.convertDateFormat(lastUpdateDate));
    }
}

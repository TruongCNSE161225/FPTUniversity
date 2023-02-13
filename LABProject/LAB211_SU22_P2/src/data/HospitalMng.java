package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import tools.MyUtil;

public class HospitalMng {

    Scanner sc = new Scanner(System.in);

    DoctorList doctorList;
    DepList depList;

    public HospitalMng() {
        doctorList = new DoctorList();
        depList = new DepList();
    }

    public void showDoctorList() {
        if (doctorList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("----------DOCTOR LIST----------");
            for (Doctor x : doctorList) {
                System.out.println(x.toString());
            }
            System.out.println("Total " + doctorList.size() + " doctor(s) from the file.");
        }
    }

    public void showDepList() {
        if (depList.isEmpty()) {
            System.out.println("Empty list!");

        } else {
            System.out.println("----------DEPARTMENT LIST----------");
            for (Department x : depList) {
                System.out.println(x.toString());
            }
            System.out.println("Total " + depList.size() + " department(s) from the file.");
        }
    }

    public void addDoctor() {
        if (depList.isEmpty()) {
            System.out.println("Please add at least 1 department!");
            return;
        }
        System.out.println("----------ADD DOCTOR PROGRAM----------");
        String doctorID;
        int pos;
        doctorID = MyUtil.readNonBlankStr("Doctor ID");
        pos = doctorList.indexOf(new Doctor(doctorID));
        if (pos >= 0) {
            System.out.println("ID duplicated!");
        } else {
            String doctorName = MyUtil.readNonBlankStr("Doctor name");
            boolean sex = MyUtil.readBool("Sex (1-Male/Another-Female)");
            String address = MyUtil.readNonBlankStr("Address");
            String depID;
            do {
                depID = MyUtil.readNonBlankStr("Department ID");
                pos = depList.indexOf(new Department(depID));
                if (pos < 0) {
                    System.out.println("Not exist!");
                }
            } while (pos < 0);
            Date createDate = new Date(System.currentTimeMillis());
            Date lastUpdateDate = null;
            Doctor doc = new Doctor(doctorID, doctorName, sex, address, depID, createDate, lastUpdateDate);
            doctorList.add(doc);
            System.out.println(doc);
            System.out.println("A doctor ID: " + doctorID + " was added successfully.");
        }
    }

    public void updateDoctor() {
        System.out.println("----------UPDATE DOCTOR PROGRAM----------");
        String doctorID;
        int pos;
        doctorID = MyUtil.readNonBlankStr("Doctor ID");
        pos = doctorList.indexOf(new Doctor(doctorID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            System.out.print("New doctor name (Enter for bypassing): ");
            String doctorName = sc.nextLine().trim();
            if (doctorName.length() > 0) {
                this.doctorList.get(pos).setDoctorName(doctorName);
            }

            boolean sex = MyUtil.readBoolUp("New sex (1-Male/Another-Female)");
            this.doctorList.get(pos).setSex(sex);

            System.out.print("New address (Enter for bypassing): ");
            String address = sc.nextLine().trim();
            if (address.length() > 0) {
                this.doctorList.get(pos).setAddress(address);
            }

            boolean OK;
            do {
                String depID = MyUtil.readNonBlankStrUp("Department ID (Enter for bypassing)");
                if (depID.length() == 0) {
                    break;
                } else {
                    OK = depList.contains(new Department(depID));
                    if (OK == true) {
                        this.doctorList.get(pos).setDepID(depID);
                    } else {
                        System.out.println("Not found!");
                    }
                }
            } while (OK == false);

            Date lastUpdateDate = new Date(System.currentTimeMillis());
            this.doctorList.get(pos).setLastUpdateDate(lastUpdateDate);

            System.out.println(doctorList.get(pos));
            System.out.println("Updated Doctor ID: " + doctorID + " successfully.");
        }
    }

    public void deleteDoctor() {
        System.out.println("----------DELETE DOCTOR PROGRAM----------");
        String doctorID;
        int pos;
        doctorID = MyUtil.readNonBlankStr("Doctor ID");
        pos = doctorList.indexOf(new Doctor(doctorID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            boolean res = MyUtil.readBoolDe("Remove the doctor ID " + doctorID + ". Really? (1-Yes/0-No)");
            if (res == true) {
                Doctor i = new Doctor(doctorID);
                doctorList.remove(i);
                System.out.println("Removed doctor ID: " + doctorID + " successfully.");
            }
        }
    }

    public void addDepartment() {
        System.out.println("----------ADD DEPARTMENT PROGRAM----------");
        String depID;
        int pos;
        depID = MyUtil.readNonBlankStr("Department ID");
        pos = depList.indexOf(new Department(depID));
        if (pos >= 0) {
            System.out.println("ID duplicated!");
        } else {
            String depName = MyUtil.readNonBlankStr("Department name");
            Date createDate = new Date(System.currentTimeMillis());
            Date lastUpdateDate = null;
            Department dep = new Department(depID, depName, createDate, lastUpdateDate);
            depList.add(dep);
            System.out.println(dep);
            System.out.println("A department ID: " + depID + " was added successfully.");
        }
    }

    public void updateDepartment() {
        System.out.println("----------UPDATE DEPARTMENT PROGRAM----------");
        String depID;
        int pos;
        depID = MyUtil.readNonBlankStr("Department ID");
        pos = depList.indexOf(new Department(depID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            System.out.print("New department name (Enter for bypassing): ");
            String depName = sc.nextLine().trim();
            if (depName.length() > 0) {
                this.depList.get(pos).setDepName(depName);
            }

            Date lastUpdateDate = new Date(System.currentTimeMillis());
            this.depList.get(pos).setLastUpdateDate(lastUpdateDate);

            System.out.println(depList.get(pos));
            System.out.println("Updated Department ID: " + depID + " successfully.");
        }
    }

    public void deleteDepartment() {
        System.out.println("----------DELETE DEPARTMENT PROGRAM----------");
        String deptID;
        int pos;
        deptID = MyUtil.readNonBlankStr("Department ID");
        pos = depList.indexOf(new Department(deptID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            if (doctorList.containsDoctor(deptID)) {
                System.out.println("Deployed. It can not be removed!");
            } else {
                boolean res = MyUtil.readBoolDe("Remove the department ID " + deptID + ". Really? (1-Yes/0-No)");
                if (res == true) {
                    Department i = new Department(deptID);
                    depList.remove(i);
                    System.out.println("Removed department ID: " + deptID + " successfully.");
                }
            }
        }
    }

    public ArrayList<Doctor> searchDoctorByName(String name) {
        ArrayList<Doctor> result = new ArrayList();
        for (Doctor x : doctorList) {
            if (name.equalsIgnoreCase(x.getDoctorName())) {
                result.add(x);
            }
        }
        return result;
    }

    public void searchDoctor() {
        System.out.println("----------SEARCH DOCTOR PROGRAM----------");
        String doctorName = MyUtil.readNonBlankStr("Doctor name");
        ArrayList<Doctor> result = searchDoctorByName(doctorName);
        if (result.isEmpty()) {
            System.out.println("Not found!");
        } else {
            for (Doctor d : result) {
                System.out.println(d.toString());
            }
        }
    }

    public void searchDepartment() {
        System.out.println("----------SEARCH DEPARTMENT PROGRAM----------");
        String depID;
        int pos;
        depID = MyUtil.readNonBlankStr("Department ID");
        pos = depList.indexOf(new Department(depID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            System.out.println("----------DEPARTMENT LIST----------");
            for (Department d : this.depList) {
                if (d.depID.equals(depID)) {
                    System.out.println(d.toString());
                }
            }
        }
    }

    public void storeDoctorListToFile() {
        System.out.println("----------STORE DOCTOR LIST PROGRAM----------");
        if (doctorList.isEmpty()) {
            System.out.println("Store data to file not successfully! Because the doctor list is empty!");
        } else {
            doctorList.writeToFile("doctor.dat");
            System.out.println("Store data doctor to file successfully.");
        }
    }
    
    public void storeDepListToFile() {
        System.out.println("----------STORE DEPARTMENT LIST PROGRAM----------");
        if (depList.isEmpty()) {
            System.out.println("Store data to file not successfully! Because the department list is empty!");
        } else {
            depList.writeToFile("department.dat");
            System.out.println("Store data department to file successfully.");
        }
    }
}

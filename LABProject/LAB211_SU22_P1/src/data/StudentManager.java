package data;

import java.util.Date;
import tools.MyUtil;
import java.util.Scanner;

public class StudentManager {

    Scanner sc = new Scanner(System.in);
    Subject sub;
    Student st;
    Transcript tr;
    SubjectList subList;
    StudentList stList;
    TranscriptList trList;

    public StudentManager() {
        subList = new SubjectList();
        stList = new StudentList();
        trList = new TranscriptList();
    }

    public void addSubject() {
        System.out.println("----------ADD SUBJECT----------");
        String subID;
        int pos;
        do {
            subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        String subName = MyUtil.readNonBlankStr("Subject name").toUpperCase();
        int credit = MyUtil.readInt("Credit (1 to 10 credits)", 1, 10);
        Subject sb = new Subject(subID, subName, credit);
        subList.add(sb);
        System.out.println(sb);
        System.out.println("A subject ID: " + subID + " was added successfully.");
    }

    public void updateSubject() {
        System.out.println("----------UPDATE SUBJECT----------");
        String subID;
        int pos;
        subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
        pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            String oldSubName = this.subList.get(pos).getSubName();
            int oldCredit = this.subList.get(pos).getCredit();
            System.out.println("Update subject:");
            System.out.print("Old subject name: " + oldSubName);
            System.out.print("\nNew subject name (Enter for bypassing): ");
            String newSubName = sc.nextLine().trim();
            if (newSubName.length() > 0) {
                this.subList.get(pos).setSubName(newSubName);
            }
            System.out.print("Old credit: " + oldCredit);
            boolean OK = true;
            String newCredit;
            do {
                System.out.print("\nNew credit (1 to 10 credits) (Enter for bypassing): ");
                newCredit = sc.nextLine().trim();
                if (newCredit.length() > 0) {
                    if (Integer.parseInt(newCredit) >= 1 && Integer.parseInt(newCredit) <= 10) {
                        OK = true;
                        this.subList.get(pos).setCredit(Integer.parseInt(newCredit));
                    } else {
                        OK = false;
                        System.out.println("Invalid input!");
                    }
                }
            } while (OK == false);
            System.out.println(subList.get(pos));
            System.out.println("Updated subject ID: " + subID + " successfully.");
        }
    }

    public void deleteSubject() {
        System.out.println("----------DELETE SUBJECT----------");
        String subID;
        int pos;
        subID = MyUtil.readNonBlankStr("Subject ID");
        pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            sub = subList.get(pos);
            if (trList.containsSubject(subID)) {
                System.out.println("Deployed. It can not be removed!");
            } else {
                boolean res = MyUtil.readBoolDe("Remove the subject ID " + subID + ". Really? (1-Yes/0-No)");
                if (res == true) {
                    Subject i = new Subject(subID);
                    subList.remove(i);
                    System.out.println("Removed Subject ID: " + subID + " successfully.");
                }
            }
        }
    }

    public void addStudent() {
        System.out.println("----------ADD STUDENT----------");
        String stID;
        int pos;
        do {
            stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        String fName = MyUtil.readNonBlankStr("First name");
        String lName = MyUtil.readNonBlankStr("Last name");
        boolean gender = MyUtil.readBool("Gender (1-Male/Another-Female)");
        Date bDate = MyUtil.readDMY("Date of birth (d/m/y)");
        String email = MyUtil.readPattern("Email (xxx@xxx.com)", MyUtil.EMAIL);
        String phone = MyUtil.readPattern("Phone number (10 to 12 numbers)", MyUtil.PHONE_10to12);
        Student stu = new Student(stID, fName, lName, gender, bDate, email, phone);
        stList.add(stu);
        System.out.println(stu);
        System.out.println("A student ID: " + stID + " was added successfully.");
    }

    public void updateStudent() {
        System.out.println("----------UPDATE STUDENT PROGRAM----------");
        String stID;
        int pos;
        stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            String oldfName = this.stList.get(pos).getfName();
            String oldlName = this.stList.get(pos).getlName();
            Boolean oldGender = this.stList.get(pos).isGender();
            Date oldBDate = this.stList.get(pos).getbDate();
            String oldEmail = this.stList.get(pos).getEmail();
            String oldPhone = this.stList.get(pos).getPhone();
            System.out.println("Update student:");
            System.out.print("Old first name: " + oldfName);
            System.out.print("\nNew first name (Enter for bypassing): ");
            String newFName = sc.nextLine().trim();
            if (newFName.length() > 0) {
                this.stList.get(pos).setfName(newFName);
            }
            System.out.print("Old last name: " + oldlName);
            System.out.print("\nNew last name (Enter for bypassing): ");
            String newLName = sc.nextLine().trim();
            if (newLName.length() > 0) {
                this.stList.get(pos).setlName(newLName);
            }
            System.out.print("Old gender: " + MyUtil.readBoolStr(oldGender));
            boolean newGender = MyUtil.readBoolUp("\nNew gender (1-Male/Another-Female)");
            this.stList.get(pos).setGender(newGender);
            System.out.print("Old date of birth: " + MyUtil.StrDMY(oldBDate));
            Date newBDate = MyUtil.readDMYUp("\nNew date of birth (d/m/y) (Enter for bypassing)");
            if (newBDate != null) {
                this.stList.get(pos).setbDate(newBDate);
            }
            System.out.print("Old email: " + oldEmail);
            String newEmail = MyUtil.readPatternUp("\nNew email (xxx@xxx.com) (Enter for bypassing)", MyUtil.EMAIL);
            if (newEmail != null) {
                this.stList.get(pos).setEmail(newEmail);
            }
            System.out.print("Old phone: " + oldPhone);
            String newPhone = MyUtil.readPatternUp("\nNew phone (10 to 12 numbers) (Enter for bypassing)", MyUtil.PHONE_10to12);
            if (newPhone != null) {
                this.stList.get(pos).setPhone(newPhone);
            }
            System.out.println(stList.get(pos));
            System.out.println("Updated Student ID: " + stID + " successfully.");
        }
    }

    public void deleteStudent() {
        System.out.println("----------DELETE STUDENT PROGRAM----------");
        String stID;
        int pos;
        stID = MyUtil.readNonBlankStr("Student ID");
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            st = stList.get(pos);
            if (trList.containsStudent(stID)) {
                System.out.println("Deployed. It can not be removed!");
            } else {
                boolean res = MyUtil.readBoolDe("Remove the student. Really? (1-Yes/0-No)");
                if (res == true) {
                    Student i = new Student(stID);
                    stList.remove(i);
                    System.out.println("Removed student ID: " + stID + " successfully.");
                }
            }
        }
    }

    public void addGrade() {
        System.out.println("----------ADD GRADE----------");
        String stID, subID;
        Student st = null;
        Subject sub = null;
        int pos;
        stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            st = stList.get(pos);
            subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos < 0) {
                System.out.println("Not found!");
            } else {
                sub = subList.get(pos);
                pos = trList.indexOf(new Transcript(st, sub));
                double labMark = 0, testMark = 0, finalMark = 0;
                Transcript t = new Transcript(st, sub, labMark, testMark, finalMark);
                if (pos < 0) {
                    labMark = MyUtil.readDouble("Lab mark", 0, 10);
                    testMark = MyUtil.readDouble("Test mark", 0, 10);
                    finalMark = MyUtil.readDouble("Final mark", 0, 10);
                    trList.add(t);
                    System.out.println("A grade was add successfully.");
                } else {
                    boolean OK = MyUtil.readBool("The student has been graded, do you want to repair? (1-Yes/0-No)");
                    if (OK == true) {
                        labMark = MyUtil.readDouble("Lab mark", 0, 10);
                        testMark = MyUtil.readDouble("Test mark", 0, 10);
                        finalMark = MyUtil.readDouble("Final mark", 0, 10);
                        trList.set(pos, t);
                        System.out.println("Updated successfully.");
                    }
                }
            }
        }
    }

    public void reportSubject() {
        System.out.println("----------SUBJECT GRADE REPORT----------");
        String stID, subID;
        Student st;
        Subject sub;
        int pos;
        subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
        pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            sub = subList.get(pos);
            boolean check = trList.containsSubject(subID);
            if (check == false) {
                System.out.println("It is nit deployed yet!");
            } else {
                System.out.println("Subject name: " + sub.subName);
                System.out.println("|++Student ID++|+++++++Student name+++++++|++Average mark++|++Status++|");
                for (Transcript t : this.trList) {
                    if (t.sub.subID.equals(subID)) {
                        String status;
                        if (t.average() >= 5) {
                            status = "Pass";
                        } else {
                            status = "Not pass";
                        }
                        System.out.printf(" %-4s  %12s %-12s\t  \t %-6f  %6s %n", t.st.stID, t.st.getfName(), t.st.getlName(), t.average(), status);
                    }
                }
            }
        }
    }

    public void reportStudent() {
        System.out.println("----------STUDENT GRADE REPORT----------");
        String stID, subID;
        Student st = null;
        Subject sub;
        int pos;
        stID = MyUtil.readNonBlankStr("Student ID").toUpperCase();
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            st = stList.get(pos);
            boolean check = trList.containsStudent(stID);
            if (check == false) {
                System.out.println("It is nit deployed yet!");
            } else {
                String name = st.getfName() + " " + st.getlName();
                System.out.println("Student name: " + name);
                System.out.println("|++No++|+++++++Subject name+++++++|++Average mark++|++Status++|");
                for (Transcript t : this.trList) {
                    if (t.st.stID.equals(stID)) {
                        String status;
                        if (t.average() >= 5) {
                            status = "Pass";
                        } else {
                            status = "Not pass";
                        }
                        System.out.printf(" %-4s  %12s\t  %18f\t %4s %n", t.sub.subID, t.sub.subName, t.average(), status);
                    }
                }
            }
        }
    }
}

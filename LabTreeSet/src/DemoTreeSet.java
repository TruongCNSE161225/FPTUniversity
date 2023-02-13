
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

class Student implements Comparable {

    private int studentId;
    String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int compareTo(Object newStudent) {
        int result;
        Student st = (Student) newStudent;
        if (studentId > st.getStudentId()) {
            result = 0;
        } else {
            result = -1;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Id=%d,Name=%s", studentId, studentName);
    }
}

public class DemoTreeSet {

    public static void main(String[] args) {
        Random r = new Random();
        TreeSet myset = new TreeSet();
        for (int i = 0; i < 10; i++) {
            int no = r.nextInt(100);
            Student st = new Student(no, "Student" + no);
            myset.add(st);
        }
        Iterator iter = myset.iterator();
        while (iter.hasNext()) {
            Student st = (Student) iter.next();
            System.out.println(st);
        }
    }
}

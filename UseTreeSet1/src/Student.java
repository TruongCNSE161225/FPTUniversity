
import java.util.Scanner;

public class Student implements Comparable {

    String ID = "";
    String name = "";
    int mark = 0;
    Scanner sc = new Scanner(System.in);

    public Student(String ID) {
        this.ID = ID;
    }

    public Student(String ID, String name, int mark) {
        this.ID = ID;
        this.name = name;
        this.mark = mark;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Object t) {
        return ID.compareTo(((Student) t).ID);
    }

    @Override
    public String toString() {
        return ID + ", " + name + ", " + mark;
    }
}

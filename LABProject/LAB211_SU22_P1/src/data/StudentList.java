package data;

import java.util.ArrayList;

public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    @Override
    public String toString() {
        String S = "";
        for (Student st : this) {
            S += st.toString() + "\n";
        }
        return S;
    }
}

package data;

import java.util.ArrayList;

public class SubjectList extends ArrayList<Subject> {

    public SubjectList() {
        super();
    }

    @Override
    public String toString() {
        String S = "";
        for (Subject sub : this) {
            S += sub.toString() + "\n";
        }
        return S;
    }
}

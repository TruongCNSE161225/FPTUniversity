package data;

import java.util.ArrayList;

public class TranscriptList extends ArrayList<Transcript> {

    public TranscriptList() {
        super();
    }

    public boolean containsSubject(String subID) {
        for (Transcript t : this) {
            if (t.sub.subID.equals(subID)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsStudent(String stID) {
        for (Transcript t : this) {
            if (t.st.stID.equals(stID)) {
                return true;
            }
        }
        return false;
    }
}

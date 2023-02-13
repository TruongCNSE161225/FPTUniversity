
import java.util.SortedSet;
import java.util.TreeSet;


public class NewClass {
    public static void main(String args[]) {
        SortedSet<StringBuffer> s = new TreeSet<>();
        s.add(new StringBuffer("Red"));
        s.add(new StringBuffer("White"));
        s.add(new StringBuffer("Blue"));
        System.out.println(s.first());
    }
}

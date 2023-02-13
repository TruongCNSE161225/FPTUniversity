
import java.util.TreeSet;
import java.util.Iterator;

public class StudentList extends TreeSet<Student> {

    public StudentList() {
        super();
    }

    public Student search(String ID) {
        return this.ceiling(new Student(ID));
    }

    public void output() {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

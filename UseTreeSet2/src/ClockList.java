
import java.util.Iterator;
import java.util.TreeSet;

public class ClockList extends TreeSet<Clock> {

    public ClockList() {
        super(Clock.comparator);
    }

    public Clock search(String ID) {
        return this.ceiling(new Clock(ID));
    }

    public void output() {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
//    public void update(){
//        String ID;
//        int pos;
//        ID = MyUtil.readNonBlankStr("ID");
//        pos = ClockList.indexOf(new Clock(ID));
//        if (pos < 0) {
//            System.out.println("Not found!");
//        } else {
//            System.out.print("New department name (Enter for bypassing): ");
//            String depName = sc.nextLine().trim();
//            if (depName.length() > 0) {
//                this.depList.get(pos).setDepName(depName);
//            }
//            System.out.println(depList.get(pos));
//            System.out.println("Updated Department ID: " + depID + " successfully.");
//        }
//    }
//    }
}

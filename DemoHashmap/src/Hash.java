
import java.util.HashMap;
import java.util.Iterator;

public class Hash {

    public static void main(String[] args) {
        HashMap mymap = new HashMap();
        mymap.put(1, "One");
        mymap.put(2, "Two");
        mymap.put(3, "Three");
        mymap.put(4, "Four");

        Iterator iter = mymap.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            System.out.println(key + ": " + mymap.get(key));
        }
    }

}

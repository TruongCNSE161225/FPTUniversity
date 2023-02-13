import java.util.*;
public class Customer implements Comparable{
    private String name;
    private int id;

    public Customer(int id, String name ) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "ID:" + id + ",Name:" + name;
    }
    public int compareTo(Object o){
        Customer s = (Customer)o;
        if(id>s.getId()){
            return 1;
        }
        else if(id==s.getId()){
            return 0;
        }
        else return -1;
    }
}

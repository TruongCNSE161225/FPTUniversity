
import java.util.List;
import java.util.Collections;


public class MyCala implements ICala{
//f1: Suppose all owners contain at least 2 characters. Count and return number of elements with owner having 2nd character (i.e. owner.charAt(1)) is a digit. 
    @Override
    public int f1(List<Cala> t) {
        int count = 0;
        for (Cala cala : t){
            if (Character.isLetter(cala.getOwner().charAt(1))){
                count++;
            }
        }
        return count;
    }
//f2: Remove the second element having maximum price (do nothing if only one max element in the list). 
    @Override
    public void f2(List<Cala> t) {
        Cala tmp, tmp1 = new Cala();
        tmp = tmp1 = t.get(0);
        for(Cala cala : t){
            if(cala.getPrice()>tmp.getPrice()){
                tmp1=tmp;
                tmp=cala;
            } else if (cala.getPrice()>= tmp1.getPrice()){
                tmp1=cala;
            }
        }
        t.remove(tmp1);
    }
//f3: Suppose all owners contain at least 2 characters. Sort the list t ascendingly by the 2nd character of owner
    @Override
    public void f3(List<Cala> t) {
      Collections.sort(t);
    }
}

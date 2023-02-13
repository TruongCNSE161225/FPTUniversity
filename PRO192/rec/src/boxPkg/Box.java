package boxPkg;
import rectPkg.Rectangle;
public class Box extends Rectangle{
    int height;
    protected int price;
    private int weight;
    void setSize (int l, int w, int h){
        super.setSize(l,w);
        height = h>0? h : 0;
    }
    int volume(){
        return length*width*height;
    }
}

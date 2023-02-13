package rectPkg;
public class Rectangle {
    protected int length;
    public int width;
    public void setSize(int l, int w){
        length = l>0? l: 0;
        width = w>0? w: 0;
    }
}

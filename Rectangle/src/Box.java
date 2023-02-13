public class Box extends Rectangle {
    private int height=0;
    public Box(){
        super();
    }
    public Box(int l, int w, int h){
        super(l, w);
        height = h>0? h: 0;
    }

    public int getHeigh() {
        return height;
    }

    public void setHeigh(int heigh) {
        this.height = height;
    }
    public String toString(){
        return "[" + getLength() + "," + getWidth() + "," + getHeigh() + "]";
    }
    public int area(){
        int l = this.getLength();
        int w = this.getWidth();
        int h = this.getHeigh();
        return 2*(l*w + w*h + h*l);
    }
    public int volumn(){
        return this.getLength()*this.getWidth()*height;
    }
}

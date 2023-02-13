
public class Rectangle {

    private int length = 0;
    private int width = 0;

    public Rectangle() {
    }

    public Rectangle(int l, int w) {
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
    }

    public String toString() {
        return "[" + getLength() + "," + getWidth() + "]";
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area() {
        return length * width;
    }
}


public class Demo_1 {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 5);
        System.out.println("Rectangle: " + r.toString());
        System.out.println("   Area: " + r.area());
        Box b = new Box(2, 2, 2);
        System.out.println("Box: " + b.toString());
        System.out.println("  Area: " + b.area());
        System.out.println("  Volumn: " + b.volumn());
    }
}

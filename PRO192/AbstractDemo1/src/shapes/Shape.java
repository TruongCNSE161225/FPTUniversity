package shapes;

public abstract class Shape {

    abstract public double circumstance();

    abstract public double area();
}

class Circle extends Shape {

    double r;

    public Circle(double rr) {
        r = rr;
    }

    public double circumstance() {
        return 2 * Math.PI * r;
    }

    public double area() {
        return Math.PI * r * r;
    }

    class Rect extends Shape {

        double l, w;

        public Rect(double ll, double ww) {
            l = ll;
            w = ww;
        }

        public double circumstance() {
            return 2 * (l + w);
        }

        public double area() {
            return l * w;
        }
    }
}

class Program {

    public static void main(String[] args) {
        Shape s = new Circle(5);
        System.out.println(s.area());
    }
}

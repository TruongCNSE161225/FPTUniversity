
class MyClass {

    static int x = 1;
    int y = 2;

    public void Print() {
        System.out.println("y:" + y);
        System.out.println("x:" + x);
    }

    public static void Display() {
        MyClass obj = new MyClass();
        System.out.println("y:" + obj.y);
        System.out.println("x:" + x);
    }
}

public class DemoMemberClass {

    public static void main(String[] args) {
        MyClass.x = 10;
        MyClass.Display();
        MyClass obj = new MyClass();
        obj.y = 5;
        obj.Print();
    }
}

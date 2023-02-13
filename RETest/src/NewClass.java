class A{
    void foo(){
        System.out.println("A");
    }
}
class B{
    void foo(){
        System.out.println("B");
    }
}
class C extends A {
    void foo(){
        System.out.println("C");
    }
}
public class NewClass {
    public static void main(String[] args) {
        Object t = new A();
        t.foo();
        
    }
}

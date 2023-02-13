
public class Main3 {
    void f(String t){
        System.out.println("String");
    }
    void f(StringBuffer h){
        System.out.println("StringBuffer");
    }
    public static void main(String argv[]) {
        f("ABC");
        System.out.println();
    }
}

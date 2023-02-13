
public class Study_2 {
    static int N=2;
    int x = 10;
    static{
        N=5;
        int y=7;
        System.out.print("A" + (N+y));
    }
    public void M(){
        System.out.print(x + y);
    }
    public static void main(String[] args) {
        Study_2 obj = new Study_2();
        obj.M();
    }
}

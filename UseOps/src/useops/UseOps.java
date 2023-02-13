package useops;
public class UseOps {
    public static void main(String[] args) {
        int x=-1;
        System.out.println("-1<<1: " + (x<<1) );
        System.out.println("-1>>1: " + (x>>1) );
        System.out.println("-1>>>1: " + (x>>>1) );
        System.out.println("3|4: " + (3|4) );
        System.out.println("3&4: " + (3&4) );
        System.out.println("3^4: " + (3^4) );
        String S="Hello";
        boolean result= S instanceof String;
        System.out.println("Hello is an instanceof String: " + result);
    }
}

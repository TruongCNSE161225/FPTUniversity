
class Output {

    public static int sum(int... x) {
        int sum = 0;
        for (int xx : x) {
            sum += xx;
        }
        return sum;
    }

    public static void main(String[] args) {
        sum(10);
        sum(10, 20);
        System.out.println(sum(10, 20));
    }
}

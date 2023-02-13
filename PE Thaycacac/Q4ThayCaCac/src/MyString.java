
public class MyString implements IString {

//fl: Count and return number of prime digits in str.
    @Override
    public int f1(String str) {
        int countPrime = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);//abcd
            if (Character.isDigit(currentChar)) {
                int currentNumber = Integer.parseInt("" + currentChar);
                if (isPrime(currentNumber)) {
                    countPrime++;
                }
            }
        }
        return countPrime;
    }
//f2: Reverse order of all words in str (word = a string without space)

    @Override
    public String f2(String str) {
        String[] words = str.split("\\s");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += " " + words[i];
        }
        return result.trim();
    }
//Kiểm tra số nguyên tố hay là không

    private boolean isPrime(int currentNumebr) {
        if (currentNumebr == 1) {
            return false;
        }
        if (currentNumebr == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(currentNumebr); i++) {
            if (currentNumebr % i == 0) {
                return false;
            }
        }
        return true;
    }

}

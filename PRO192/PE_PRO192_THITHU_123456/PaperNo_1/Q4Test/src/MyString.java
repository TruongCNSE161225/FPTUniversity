
public class MyString implements IString {
//f1: Count and return number of words containing at least 1 odd digit
    @Override
    public int f1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                int currentNumber = Integer.parseInt("" + currentChar);
                if (currentNumber % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
//f2: Return the string s, which is obtained by replacing the (first) palindrom word in str with the string "XX" (word = a string without spaces(s), a word is called palindrom if it and its reverse are the same)
    @Override
    public String f2(String str) {
        String tmp = "";
        int k = 0, j = 0;
        int tmp1 = 0, tmp2 = 0;
        for (int i = 1; i < str.length(); i++) {
            k = i;
            j = i;
            while (k < str.length() - 1 && (str.charAt(k + 1) == str.charAt(j - 1))) {
                tmp1 = j--;
                tmp2 = k++;
            }
        }
        tmp = str.substring(0, tmp1 - 1) + "XX" + str.substring(tmp2 + 2);
        return tmp;
    }
}

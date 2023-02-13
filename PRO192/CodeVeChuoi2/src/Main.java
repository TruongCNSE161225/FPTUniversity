
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //IN HOA KÝ TỰ ĐẦU TIÊN CỦA MỖI CHỮ TRONG CHUỖI
        // sử dụng class Scanner để nhận dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);
        String message;
        System.out.println("\n\nNhập vào chuỗi cần in hoa ký tự đầu: ");
        message = sc.nextLine();
        //khai báo một mảng, sau đó sử dụng phương thức toCharArray() 
        //để chuyển đổi message thành một mảng kiểu char
        char[] charArray = message.toCharArray();
        boolean foundSpace = true;
        //sử dụng vòng lặp for để duyệt các phần tử trong charArray
        for (int i = 0; i < charArray.length; i++) {
            // nếu phần tử trong mảng là một chữ cái
            if (Character.isLetter(charArray[i])) {
                // kiểm tra khoảng trắng có trước chữ cái
                if (foundSpace) {
                    //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        // chuyển đổi mảng char thành string
        message = String.valueOf(charArray);
        System.out.println("Chuỗi sau khi đổi: \n" + message);

        System.out.println("\n---------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //IN HOA KÝ TỰ ĐẦU TIÊN CỦA MỘT CHỮ
        //khai báo và khởi tạo một string name
        String name = "freetuts.net";
        System.out.println("\n\nChuỗi ban đầu: " + name);
        // tạo hai chuỗi con firstLetter và remainingLetters
        // chuỗi firstLetter chứa chữ cái đầu tiên của  name
        String firstLetter = name.substring(0, 1);
        // chuỗi remainingLetters chứa phần còn lại của name
        String remainingLetters = name.substring(1, name.length());

        //sử dụng phương thức toUpperCase() để chuyển đổi firstLetter thành chữ in hoa
        firstLetter = firstLetter.toUpperCase();

        //sau khi chuyển đổi thì gộp chúng lại
        name = firstLetter + remainingLetters;
        System.out.println("Chuỗi sau khi đổi: " + name);

        System.out.println("\n---------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //XOÁ MẢNG TRẮNG CỦA MỘT CHUỖI
        //khai báo và khởi tạo một chuỗi có nội dung nhất địng
        String sentence = "F   re et     u  t  s.n et";
        System.out.println("\n\nChuỗi ban đầu: " + sentence);
        //sử dụng phương thức replaceAll() để xóa khoảng trắng
        sentence = sentence.replaceAll(" ", "");
        System.out.println("Chuỗi sau khi xóa khoảng trắng: " + sentence);

        System.out.println("\n----------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //CHUYỂN CHỮ HOA THÀNH CHỮ THƯỜNG
        // sử dụng class Scanner để nhận dữ liệu từ bàn phím
        Scanner sac = new Scanner(System.in);
        String messages;
        System.out.println("\n\nNhập vào chuỗi cần chuyển đổi: ");
        messages = sac.nextLine();
        //khai báo một mảng, sau đó sử dụng phương thức toCharArray()
        //để chuyển đổi message thành một mảng kiểu char
        char[] charArray1 = messages.toCharArray();
        //sử dụng vòng lặp for để duyệt các phần tử trong charArray
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] >= 65 && charArray1[i] <= 90) {
                charArray1[i] += 32;
            }
        }
        // chuyển đổi mảng char thành string
        messages = String.valueOf(charArray1);
        System.out.println("Chuỗi sau khi đổi: \n" + messages);

        System.out.println("\n---------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //CHUYỂN CHỮ THƯỜNG THÀNH CHỮ HOA
        // sử dụng class Scanner để nhận dữ liệu từ bàn phím
        Scanner sca = new Scanner(System.in);
        String message1;
        System.out.println("\n\nNhập vào chuỗi cần in hoa: ");
        message1 = sca.nextLine();
        System.out.println("Chuỗi sau khi in hoa: ");
        //sử dụng phương thức toUpperCase() để in hoa các ký tự trong chuỗi
        System.out.println(message1.toUpperCase());
        System.out.println("\n---------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");
        
        //CHUỖI ĐỐI XỨNG
        System.out.print("Nhập vào chuỗi bạn muốn kiểm tra:");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        Stack stack = new Stack();
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }
        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString = reverseString + stack.pop();
        }
        if (inputString.equals(reverseString)) {
            System.out.println("Đây là chuỗi đối xứng.");
        } else {
            System.out.println("Đây không phải là chuỗi đối xứng.");
        }
    }
}

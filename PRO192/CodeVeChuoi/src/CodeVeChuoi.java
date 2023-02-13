
import java.util.Scanner;

public class CodeVeChuoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Nhập vào chuỗi: ");
        s = sc.nextLine();
        System.out.println("------");

        // Hàm length() => lấy độ dài chuỗi
        System.out.println(s.length());
        int doDai = s.length();
        String s1 = "titv.vn";
        String s2 = "TITV.vn";
        String s3 = "titv.vn";

        // Hàm equals => so sánh 2 chuỗi giống nhau, có phân biệt Hoa Thường
        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 equals s3: " + s1.equals(s3));

        // Hàm equalsIgnoreCase, so sánh 2 chuỗi giống nhau, ko phân biệt hoa thường
        System.out.println("s1 equalsIgnoreCase s2: " + s1.equalsIgnoreCase(s2));
        System.out.println("s1 equalsIgnoreCase s3: " + s1.equalsIgnoreCase(s3));

        // Nếu các bạn só sánh tài khoản và mật khẩu của người khi đăng nhâp
        // Bạn sẽ dùng equals hoặc euqalsIgnoreCase?
        // Hàm compareTo => so sánh > < =
        String sv3 = "Nguyễn Văn";
        String sv1 = "Nguyễn Văn A";
        String sv2 = "Nguyễn Văn B";
        String sv4 = "Nguyễn Văn a";

        System.out.println("sv1 compareTo sv2: " + sv1.compareTo(sv2));
        System.out.println("sv1 compareTo sv3: " + sv1.compareTo(sv3));
        System.out.println("sv1 compareTo sv4: " + sv1.compareTo(sv4));

        // Hàm compareToIgnoreCase => Tường tự hàm compareTo, không biệt chữ hoa chữ thường
        // Hàm regionMatches => so sánh một đoạn
        String r1 = "TITV.vn";
        String r2 = "TV.v";
        boolean check = r1.regionMatches(2, r2, 0, 4);
        System.out.println(check);

        // 0937 456 789
        // 0937 455 765
        // Hàm startWith => Hàm kiểm tra chuỗi bắt đầu bằng ....
        String sdt = "037456789";
        System.out.println(sdt.startsWith("037"));
        System.out.println(sdt.startsWith("034"));

        // Hàm endWith => Hàm kiểm tra chuỗi kết thúc bằng ...
        String tenFile = "I love you.JPG";
        String tenFile2 = "Hoc Java.PDF";

        if (tenFile.endsWith(".JPG")) {
            System.out.println("File 1 là hình ảnh!");
        } else if (tenFile.endsWith(".PDF")) {
            System.out.println("File 1 là file PDF!");
        }

        if (tenFile2.endsWith(".JPG")) {
            System.out.println("File 2 là hình ảnh!");
        } else if (tenFile2.endsWith(".PDF")) {
            System.out.println("File 2 là file PDF!");
        }

        String ss1 = "Xin chào cô chú, xin chào các bạn, Xin chào!";
        String ss2 = "Xin chào";
        String ss3 = "Xin chào 123";
        char c1 = 'ô';
        // Hàm indexOf
        System.out.println("Vị trí của s2 trong s1 là: " + s1.indexOf(ss2));
        System.out.println("Vị trí của s3 trong s1 là: " + s1.indexOf(ss3));

        // Sử dụng vị trí bắt đầu
        System.out.println("Vị trí của s2 trong s1 là: " + s1.indexOf(ss2, 2));

        // Tìm kiếm char
        System.out.println("Vị trí của c1 trong s1 là: " + s1.indexOf(c1));
        System.out.println("Vị trí của c1 trong s1 là: " + s1.indexOf(c1, 20));

        // Hàm lastIndexof => tìm kiếm từ phải sang trái
        System.out.println("Vị trí của s2 trong s1 (từ phải sang trái) là: " + ss1.lastIndexOf(ss2));

        String sss1 = "tItv";
        String sss2 = ".Vn";

        String sss3 = sss1 + sss2;
        // Hàm concat => nối chuỗi
        String sss4 = sss1.concat(sss2);
        System.out.println("s3= " + sss3);
        System.out.println("s4= " + sss4);

        // Hàm replaceAll => thay thế
        String sss5 = "Tung.vn";
        String sss6 = sss5.replaceAll("Tung", "TITV");
        System.out.println("s6 = " + sss6);

        // toLowerCase => chuyển về viết thường
        // toUpperCase => chuyển về viết hoa
        String sss7 = sss3.toLowerCase();
        String sss8 = sss3.toUpperCase();
        System.out.println("s7 = " + sss7);
        System.out.println("s8 = " + sss8);

        // trim() => xóa khoảng trắng dư thừa ở đầu chuỗi
        String sss9 = "  Xin chào các bạn, mình là TITV.vn    ";
        System.out.println(sss9.trim());

        /// subString => cắt chuỗi con
        String sss10 = "Xin chào các bạn, mình là TITV.vn";
        String sss11 = sss10.substring(10);
        String sss12 = sss10.substring(10, 15);
        System.out.println("s11 = " + sss11);
        System.out.println("s12 = " + sss12);
    }
}

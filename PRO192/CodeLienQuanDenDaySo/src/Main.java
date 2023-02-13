
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Swap hai số
        //sử dụng class Scanner để lấy dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);
        //khai báo ba biến float a, b và temp
        float a, b, temp;
        // yêu cầu người dùng nhập vào hai số a và b
        System.out.println("\n\nNhập vào số a: ");
        a = sc.nextFloat();
        System.out.println("Nhập vào số b: ");
        b = sc.nextFloat();
        //sử dụng thuật toán hoán đổi với biến trung gian temp
        temp = a;
        a = b;
        b = temp;
        //sau khi hoán đổi thì hiển thị kết quả ra màn hình
        System.out.println("Sau khi hoán đổi\na = " + a + "\nb = " + b);

        System.out.println("---------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //Tìm số lớn nhất trong mảng
        //sử dụng class Scanner để lấy dữ liệu từ bàn phím
        Scanner sac = new Scanner(System.in);
        //khai báo biến n là số lượng phần tử trong mảng
        int n;
        System.out.print("\n\nNhập số lượng phần tử cho mảng: ");
        n = sac.nextInt();
        int numberArr[] = new int[n];
        //nhập giá trị cho từng phần tử trong mảng
        for (int i = 0; i < n; i++) {
            System.out.print("\nNhập phần tử thứ " + i + ": ");
            numberArr[i] = sac.nextInt();
        }
        //in các phần tử trong mảng ra màn hình
        System.out.println("Các phần tử trong mảng là: ");
        for (double i : numberArr) {
            System.out.print(i + ", ");
        }
        double max = numberArr[0];
        //dùng vòng lặp for duyệt các phần tử trong mảng. so sánh max với từng phần tử nếu số nào lớn hơn max thì gán nó cho max.
        // cứ lặp như vậy cho đến hết các phần tử thì max sẽ là giá trị lớn nhất trong mảng
        for (double num : numberArr) {
            if (max < num) {
                max = num;
            }
        }
        System.out.printf("\nSố lớn nhất trong mảng là: %.2f", max);

        System.out.println("\n----------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //Thuật toán tìm ước số(GCD)
        //sử dụng class Scanner để lấy dữ liệu từ bàn phím
        Scanner scc = new Scanner(System.in);
        //khai báo biến n là số cần tìm ước số
        int m;
        //yêu cầu người dùng nhập vào số cần tìm ước số
        System.out.println("\n\nNhập vào số cần tìm ước số: ");
        m = scc.nextInt();
        System.out.printf("Các ước số của %d là: ", m);
        //sử dụng vòng lặp for lặp từ 1 đến n, với bước nhảy ++
        for (int i = 1; i <= m; i++) {
            //nếu number chia hết cho i thì in i ra màn hình
            if (m % i == 0) {
                System.out.print(i + "\t");
            }
        }

        System.out.println("\n----------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");

        //Tìm bội chung nhỏ nhất (LCM)
        //sử dụng class Scanner để lấy dữ liệu từ bàn phím
        Scanner scan = new Scanner(System.in);
        //khai báo n1, n2 là hai số cần tính bội chung nhỏ nhất
        //lcm là bội chung nhỏ nhất của a và b
        int n1, n2, lcm;
        System.out.println("\n\nNhập vào số thứ nhất: ");
        n1 = scan.nextInt();
        System.out.println("Nhập vào số thứ hai: ");
        n2 = scan.nextInt();
        //sử dụng toán tử ba ngôi để gán giá trị lớn nhất giữa a và b cho lcm
        //->> vì bcnn của a và b luôn luôn lớn hơn a và b
        lcm = (n1 > n2) ? n1 : n2;
        //sử dụng vòng lặp while với điều kiện true để lặp đến khi nào gặp lệnh break;
        while (true) {
            //nếu lcm chia hết cho n1 và n2, tức là lcm chính là bcnn của a và b
            if (lcm % n1 == 0 && lcm % n2 == 0) {
                System.out.printf("Bội chung nhỏ nhất của %d và %d là %d.", n1, n2, lcm);
                break;
            }
            //lcm bắt đầu từ giá trị lớn nhất giữa a và b, nếu không phải là bcnn thì tăng lên 1 rồi tiếp tục kiểm tra, cứ như vậy cho đến khi tìm được
            ++lcm;
        }
        System.out.println("------------------------------------");
        System.out.println("Chương trình này được đăng tại Freetuts.net");
    }
}


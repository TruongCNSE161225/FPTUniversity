import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        MatHang thongSo = null;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Nhap hang socola.");
            System.out.println("2. Nhap hang milk.");
            System.out.println("3. Xuat thong tin.");
            System.out.println("4. Thoat.");
            System.out.println("Xin moi ban chon: ");
            choice = sc.nextInt();
            switch (choice){
                case 1: 
                    thongSo = new Socola();
                    
            }
        } while (choice <= 4);
    }
}

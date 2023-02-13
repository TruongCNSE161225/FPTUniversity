
import java.util.*;

public class Program {

    public static void main(String[] args) {
        double a, b, r;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai hinh chu nhat: ");
        a = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap chieu rong hinh chu nhat: ");
        b = Double.parseDouble(sc.nextLine());
        /*if (a < b) {
            System.out.println("Ban da nhap sai kich thuoc cua hinh chu nhat");
        } else {
            HinhChuNhat hcn = new HinhChuNhat(a, b);
            System.out.println("Chu vi va dien tich hinh chu nhat: ");
            hcn.tinhChuViDienTich();
            hcn.xemChuViDienTich();
        }*/
        HinhChuNhat hcn = new HinhChuNhat(a, b);
        System.out.println("Chu vi va dien tich hinh chu nhat: ");
        hcn.tinhChuViDienTich();
        hcn.xemChuViDienTich();
        System.out.print("Nhap ban kinh hinh tron: ");
        r = Double.parseDouble(sc.nextLine());
        HinhTron ht = new HinhTron(r);
        System.out.println("Chu vi va dien tich hinh tron: ");
        ht.tinhChuViDienTich();
        ht.xemChuViDienTich();
    }
}

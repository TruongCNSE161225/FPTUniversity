
import java.lang.*;

public class HinhTron extends HinhHoc {

    private double banKinh;

    public HinhTron(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public void tinhChuViDienTich() {
        chuVi = 2 * Math.PI * banKinh;
        dienTich = Math.PI * Math.pow(banKinh, 2);
    }
}

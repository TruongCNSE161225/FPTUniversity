
public class HinhChuNhat extends HinhHoc {

    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public void tinhChuViDienTich() {
        chuVi = (chieuDai + chieuRong) * 2;
        dienTich = chieuDai * chieuRong;
    }
}


public abstract class HinhHoc {

    protected double chuVi;
    protected double dienTich;

    public abstract void tinhChuViDienTich();

    public void xemChuViDienTich() {
        System.out.format("Chu vi = %.2f, Dien tich = %.2f\n", chuVi, dienTich);
    }
}

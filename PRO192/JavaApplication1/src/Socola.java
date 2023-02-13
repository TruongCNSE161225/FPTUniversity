
import java.util.Scanner;


public class Socola extends MatHang {

    private String mMauSac;
    private String mDonViTinh;
    //constructor
    public Socola(){
        
    }

    public Socola(String mMauSac, String mDonViTinh) {
        this.mMauSac = mMauSac;
        this.mDonViTinh = mDonViTinh;
    }
    //getter

    public String getmMauSac() {
        return mMauSac;
    }

    public String getmDonViTinh() {
        return mDonViTinh;
    }
    //setter

    public void setmMauSac(String mmMauSac) {
        this.mMauSac = mMauSac;
    }

    public void setmDonViTinh(String mDonViTinh) {
        this.mDonViTinh = mDonViTinh;
    }
    //method
    public void nhapSocola(){
        nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mau sac: ");
        mMauSac = sc.nextLine();
        System.out.println("Nhap don vi tinh: ");
        mDonViTinh = sc.nextLine();
    }

    @Override
    public void XemChiTiet() {
        super.XemChiTiet();
    }

    @Override
    public void ThanhTien() {
        int TongTien;
        TongTien = (int) (mSoLuong * mDonGia);
    }
}

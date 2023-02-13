
import java.util.Date;
import java.util.Scanner;

public class Milk extends MatHang {

    private Date mNgaySanXuat;
    private Date mHanSuDung;
    private String mDonViTinh;
    //constructor

    public Milk(Date mNgaySanXuat, Date mHanSuDung, String mDonViTinh) {
        this.mNgaySanXuat = mNgaySanXuat;
        this.mHanSuDung = mHanSuDung;
        this.mDonViTinh = mDonViTinh;
    }
    //getter

    public Date getmNgaySanXuat() {
        return mNgaySanXuat;
    }

    public Date getmHanSuDung() {
        return mHanSuDung;
    }

    public String getmDonViTinh() {
        return mDonViTinh;
    }
    //setter

    public void setmNgaySanXuat(Date mNgaySanXuat) {
        this.mNgaySanXuat = mNgaySanXuat;
    }

    public void setmHanSuDung(Date mHanSuDung) {
        this.mHanSuDung = mHanSuDung;
    }

    public void setmDonViTinh(String mDonViTinh) {
        this.mDonViTinh = mDonViTinh;
    }
    //method
    public void nhapMilk(){
        nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ngay san xuat: ");
        mNgaySanXuat = 
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

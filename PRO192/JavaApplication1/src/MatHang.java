
import java.util.Scanner;


public abstract class MatHang {

    protected String mMaHang;
    protected String mTenHang;
    protected float mDonGia;
    protected int mSoLuong;

    //constructor
    public MatHang() {

    }

    public MatHang(String mMaHang, String mTenHang, float mDonGia, int mSoLuong) {
        this.mMaHang = mMaHang;
        this.mTenHang = mTenHang;
        this.mDonGia = mDonGia;
        this.mSoLuong = mSoLuong;
    }
    //getter

    public String getmMaHang() {
        return mMaHang;
    }

    public String getmTenHang() {
        return mTenHang;
    }

    public float getmDonGia() {
        return mDonGia;
    }

    public int getmSoLuong() {
        return mSoLuong;
    }
    //setter

    public void setmMaHang(String mMaHang) {
        this.mMaHang = mMaHang;
    }

    public void setmTenHang(String mTenHang) {
        this.mTenHang = mTenHang;
    }

    public void setmDonGia(float mDonGia) {
        this.mDonGia = mDonGia;
    }

    public void setmSoLuong(int mSoLuong) {
        this.mSoLuong = mSoLuong;
    }
    //method
    public void nhap(){
         Scanner scan = new Scanner(System.in);
         System.out.println("Nhap ma hang: ");
         mMaHang = scan.nextLine();
         System.out.println("Nhap ten hang: ");
         mTenHang = scan.nextLine();
         System.out.println("Nhap don gia: ");
         mDonGia = scan.nextFloat();
         System.out.println("Nhap so luong: ");
         mSoLuong = scan.nextInt();
        }
        
    public abstract void ThanhTien();

    public void XemChiTiet() {
        System.out.println("Ma Hang: " + mMaHang);
        System.out.println("Ten Hang: " + mTenHang);
        System.out.println("Don Gia: " + mDonGia);
        System.out.println("So Luong: " + mSoLuong);
    }
}

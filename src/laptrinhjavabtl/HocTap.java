/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laptrinhjavabtl;

/**
 *
 * @author admin
 */
public class HocTap {
    private String maMH;
    private String maSV;
    private int tinChi;
    private double diemThi;

    public HocTap(String maMH, String maSV, int tinChi, double diemThi) {
        this.maMH = maMH;
        this.maSV = maSV;
        this.tinChi = tinChi;
        this.diemThi = diemThi;
    }

    public HocTap() {
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    public double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(double diemThi) {
        this.diemThi = diemThi;
    }

    

}

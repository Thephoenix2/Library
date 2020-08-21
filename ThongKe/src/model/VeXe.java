/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class VeXe {
    String veXe;
    int loaiKH;
   private String hinh1;
   private String hinh2;

    public VeXe() {
    }

    public VeXe(String veXe, int loaiKH, String hinh1, String hinh2) {
        this.veXe = veXe;
        this.loaiKH = loaiKH;
        this.hinh1 = hinh1;
        this.hinh2 = hinh2;
    }

    public String getVeXe() {
        return veXe;
    }

    public void setVeXe(String veXe) {
        this.veXe = veXe;
    }

    public int getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(int loaiKH) {
        this.loaiKH = loaiKH;
    }

    public String getHinh1() {
        return hinh1;
    }

    public void setHinh1(String hinh1) {
        this.hinh1 = hinh1;
    }

    public String getHinh2() {
        return hinh2;
    }

    public void setHinh2(String hinh2) {
        this.hinh2 = hinh2;
    }
    
}

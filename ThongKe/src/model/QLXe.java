/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class QLXe {
     String id;   
     String veXe;
     String loaiXe;
     int loaiKH;
     Date ngayVao;
   private String hinh1;
   private String hinh2;
   private String hinh3;
   private String hinh4;
   Date ngayRa;

    public QLXe() {
    }

    public QLXe(String id, String veXe, String loaiXe, int loaiKH, Date ngayVao, String hinh1, String hinh2, String hinh3, String hinh4, Date ngayRa) {
        this.id = id;
        this.veXe = veXe;
        this.loaiXe = loaiXe;
        this.loaiKH = loaiKH;
        this.ngayVao = ngayVao;
        this.hinh1 = hinh1;
        this.hinh2 = hinh2;
        this.hinh3 = hinh3;
        this.hinh4 = hinh4;
        this.ngayRa = ngayRa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVeXe() {
        return veXe;
    }

    public void setVeXe(String veXe) {
        this.veXe = veXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(int loaiKH) {
        this.loaiKH = loaiKH;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
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

    public String getHinh3() {
        return hinh3;
    }

    public void setHinh3(String hinh3) {
        this.hinh3 = hinh3;
    }

    public String getHinh4() {
        return hinh4;
    }

    public void setHinh4(String hinh4) {
        this.hinh4 = hinh4;
    }

    public Date getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(Date ngayRa) {
        this.ngayRa = ngayRa;
    }

    
    
   

    

   
}

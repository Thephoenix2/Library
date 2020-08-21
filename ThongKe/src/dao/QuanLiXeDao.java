/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.DateHelper;
import helper.JdbcHelper;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.QLXe;
import model.VeXe;

/**
 *
 * @author DELL
 */
public class QuanLiXeDao {
     public void showDetail(JTable tbl) {
        String header[] = {"id","Mã Vé Xe","Loại xe", "Khách Hàng","Ngày vào","Hình1", "Hình2","Hình3", "Hình4", "Ngày ra"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from QuanLiXe";
            ResultSet rs = st.executeQuery(sql);
           
            while (rs.next()) {
                Vector row = new Vector();
                  row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                   if (rs.getInt(4) == 1) {
                    row.add("Định cư");
                } else {
                    row.add("Vãng Lai");
                }
           
                row.add(DateHelper.toString(rs.getDate(5)));
             //   row.add(rs.getDate(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                 row.add(rs.getString(8));                
                row.add(rs.getString(9));
           row.add(DateHelper.toString(rs.getDate(10)));

              
           
                model.addRow(row);
            }
            tbl.setModel(model);
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public QLXe hienthi(JTable tbl) {
        int khachHang = 0;
        String id = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        String veXe = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1));
        String loaiXe = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 2));
        String loaiKH = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 3));
        if (loaiKH.equals("Định cư")) {
            khachHang = 0;
        } else {
            khachHang = 1;
        }
        Date ngayVao = DateHelper.toDate(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 4)));
        String Hinh1 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 5));
        String Hinh2 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 6));
        String Hinh3 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 7));
        String Hinh4 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 8));
        Date ngayRa = DateHelper.toDate(String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 9)));
        QLXe qlx = new QLXe(id, veXe, loaiXe, khachHang, ngayVao, Hinh1, Hinh2, Hinh3,Hinh4, ngayRa);
        return qlx;
    }
      
  
      
         public String chonAnh(JLabel lbllogo) {
        String fileimage = "";
        BufferedImage img = null;
        JFileChooser filec = new JFileChooser("src\\matnguoi\\");
        int r = filec.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fl = filec.getSelectedFile();
            try {
                img = ImageIO.read(fl);
                String qaz = String.valueOf(fl);
                String[] str = qaz.split("\\\\");
                fileimage = str[str.length - 1];
                JOptionPane.showMessageDialog(null, fileimage);
                ImageIO.write(img, "jpg", new File("src\\matnguoi\\" + str[str.length - 1]));
                Image dmg = img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dmg);
                lbllogo.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileimage;
    }
         
                  public String chonAnh1(JLabel lbllogo) {
        String fileimage = "";
        BufferedImage img = null;
        JFileChooser filec = new JFileChooser("src\\soxe\\");
        int r = filec.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fl = filec.getSelectedFile();
            try {
                img = ImageIO.read(fl);
                String qaz = String.valueOf(fl);
                String[] str = qaz.split("\\\\");
                fileimage = str[str.length - 1];
                JOptionPane.showMessageDialog(null, fileimage);
                ImageIO.write(img, "jpg", new File("src\\soxe\\" + str[str.length - 1]));
                Image dmg = img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dmg);
                lbllogo.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileimage;
    }
                  
                  
                  
                  
                      public int insertItem(QLXe vx) {
                          int kq = 0;
                          Connection cn = new MyConnection().getConnect();
               if (cn == null) {
            return -1; }
        try {                   
            PreparedStatement stm = cn.prepareStatement("insert into QuanLiXe values(?,?,?,?,?,?,?,?,?,?)");
                                 

 stm.setString(1, vx.getId());
            stm.setString(2, vx.getVeXe());
            stm.setString(3, vx.getLoaiXe());
            stm.setInt(4, vx.getLoaiKH());   
            stm.setDate(5, new java.sql.Date(vx.getNgayVao().getTime()));
           // stm.setDate(5, (java.sql.Date) vx.getNgayVao());
            stm.setString(6, vx.getHinh1());    
             
            stm.setString(7, vx.getHinh2());
         
     
            stm.setString(8, vx.getHinh3());
            stm.setString(9, vx.getHinh4());
            stm.setDate(10, new java.sql.Date(vx.getNgayRa().getTime()));
        stm.executeUpdate();
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
                      
                      public int deteleItem(String id) {
                  int kq = 0;
        //1. kết nối
        Connection cn = new MyConnection().getConnect();
        if (cn == null) {
            return -1; // kết nối không thành công
        }
        try {
            //PreparedStatement ps = cn.prepareStatement("delete from NhanVien where MaNV=?"); //CÁCH 1 LÚC TRƯỚC
            PreparedStatement ps = cn.prepareStatement("{call spQuanLiXe_delete(?)}"); //CÁCH 2 GỌI STORE
            //2. truyền giá trị vào cho đối số ?

            ps.setString(1, id);
            kq = ps.executeUpdate();
            //kq = 0 : xóa thất bại kq=1 : xóa được 1 dòng
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
              }
                      public int update(QLXe vx) {
        int kq = 0;
        Connection cn = new MyConnection().getConnect();
        if (cn == null) {
            return -1;
        }
        try {
            PreparedStatement stm = cn.prepareStatement("update QuanLiXe set MaVeXe=?, LoaiXe=?, KhachHang=?, ngayVao=?, hinh1=?,hinh2=?,hinh3=?,hinh4=?,ngayRa=? where id=?");
            
           stm.setString(10, vx.getId()); 
            stm.setString(1, vx.getVeXe());
            stm.setString(2, vx.getLoaiXe());
            stm.setInt(3, vx.getLoaiKH());   
            stm.setDate(4, new java.sql.Date(vx.getNgayVao().getTime()));
            stm.setString(5, vx.getHinh1());
            stm.setString(6, vx.getHinh2());
            stm.setString(7, vx.getHinh3());
            stm.setString(8, vx.getHinh4());
            stm.setDate(9, new java.sql.Date(vx.getNgayRa().getTime()));
        
            stm.executeUpdate();

            kq = stm.executeUpdate();
            stm.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
                      
                      
                      
                      
                      
                      
                      
                      

}

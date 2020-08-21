/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;
import model.VeXe;
import ui.VeXeJFrame;

/**
 *
 * @author DELL
 */
public class VeXeDao {
    
      public void showDetail(JTable tbl) {
        String header[] = {"Mã Vé Xe", "Khách Hàng","Hình1", "Hình2"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from QuanLiVe";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                   if (rs.getInt(2) == 1) {
                    row.add("Định cư");
                } else {
                    row.add("Vãng Lai");
                }
                row.add(rs.getString(3));
                row.add(rs.getString(4));
           
                model.addRow(row);
            }
            tbl.setModel(model);
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
        public VeXe hienthi(JTable tbl) {
            int loaiKH = 0;
        String veXe = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 0));
        String vitri = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 1));
           if (vitri.equals("Vãng Lai")) {
           loaiKH = 0;
        } else {
            loaiKH = 1;
        }
          String hinh1 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 2));
            String hinh2 = String.valueOf(tbl.getValueAt(tbl.getSelectedRow(), 3));
    
        VeXe cd = new VeXe(veXe, loaiKH, hinh1, hinh2);
        return cd;
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
         
             public void insertItem(VeXe vx) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "insert into QuanLiVe values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, vx.getVeXe());
            stm.setInt(2, vx.getLoaiKH());
            stm.setString(3, vx.getHinh1());
            stm.setString(4, vx.getHinh2());
        
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
             
             public int deteleItem(String MaVeXe) {
                  int kq = 0;
        //1. kết nối
        Connection cn = new MyConnection().getConnect();
        if (cn == null) {
            return -1; // kết nối không thành công
        }
        try {
            //PreparedStatement ps = cn.prepareStatement("delete from NhanVien where MaNV=?"); //CÁCH 1 LÚC TRƯỚC
            PreparedStatement ps = cn.prepareStatement("{call spQuanLiVe_delete(?)}"); //CÁCH 2 GỌI STORE
            //2. truyền giá trị vào cho đối số ?

            ps.setString(1, MaVeXe);
            kq = ps.executeUpdate();
            //kq = 0 : xóa thất bại kq=1 : xóa được 1 dòng
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
              }
         

      
      
}

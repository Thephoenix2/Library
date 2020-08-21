/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import dao.MyConnection;
import dao.QuanLiXeDao;
import dao.VeXeDao;
import helper.DateHelper;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.QLXe;
import model.VeXe;
import org.opencv.core.Core;

/**
 *
 * @author DELL
 */
public class QuanLiXe extends javax.swing.JFrame {
    String Hinh1="";
    String Hinh2="";
    String fileimage1 = "";
 String fileimage2 = "";
     String fileimage3 = "";
         String fileimage4 = "";


   public void chonHinh(){
        fileimage1= new QuanLiXeDao().chonAnh(lblHinh1);
        
  
    }
     public void chonHinh1(){
        fileimage2= new QuanLiXeDao().chonAnh1(lblHinh2);
  
    }
      public void showList() {
        new QuanLiXeDao().showDetail(tblxe);
    }
      
public void hienthi() throws IOException {
        QLXe qlx = new QuanLiXeDao().hienthi(tblxe);
        txtVeXe.setText(qlx.getVeXe());
        txtid.setText(qlx.getId());
        cboloai.setSelectedItem(qlx.getLoaiXe());
        if (qlx.getLoaiKH()== 0) {
            rdoDinhCu.setSelected(true);
        } else {
            rdoVangLai.setSelected(true);
        }
        txtngayvao.setText(String.valueOf(qlx.getNgayVao()));
        Hinh1  = qlx.getHinh1();
        Hinh2 = qlx.getHinh2();      
        fileimage3=qlx.getHinh3();
        fileimage4=qlx.getHinh4();
        BufferedImage img = ImageIO.read(new File("src\\matnguoi\\" + Hinh1));
           BufferedImage img1 = ImageIO.read(new File("src\\soxe\\" + Hinh2));
        Image dmg = img.getScaledInstance(lblHinh1.getWidth(), lblHinh1.getHeight(), Image.SCALE_SMOOTH);
     Image  dmg1 = img1.getScaledInstance(lblHinh2.getWidth(), lblHinh2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dmg);
        lblHinh1.setIcon(icon);
        ImageIcon icon1 = new ImageIcon(dmg1);
        lblHinh2.setIcon(icon1);
        
                BufferedImage img2 = ImageIO.read(new File("src\\matnguoi\\" + fileimage3));
           BufferedImage img3 = ImageIO.read(new File("src\\soxe\\" + fileimage4));
        Image dmg2 = img2.getScaledInstance(lblHinh3.getWidth(), lblHinh3.getHeight(), Image.SCALE_SMOOTH);
     Image  dmg3 = img3.getScaledInstance(lblHinh4.getWidth(), lblHinh4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(dmg2);
        lblHinh3.setIcon(icon2);
        ImageIcon icon3 = new ImageIcon(dmg3);
        lblHinh4.setIcon(icon3);
    txtngayra.setText(String.valueOf(qlx.getNgayRa()));
         
     
    }

 
       public void loadDataToCbo() {
       
     try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from QuanLiVe ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cboVeXe.addItem(rs.getString("MaVeXe"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
       
          public void selectItem() {
        try {
         Connection con =  new MyConnection().getConnect();           
            String sql = "select * from QuanLiVe where MaVeXe = ?"; 
              String ma = (String) cboVeXe.getSelectedItem();
            PreparedStatement stm = con.prepareStatement(sql);
          stm.setString(1,ma);
           ResultSet rs = stm.executeQuery();     
          while (rs.next()) {
              txtVeXe.setText(ma);             
           int loaiKH = rs.getInt("KhachHang");       
         if(loaiKH==0)
             rdoVangLai.setSelected(true);
         else                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
            rdoDinhCu.setSelected(true);
         
          Hinh1 = rs.getString("Hinh1");
          Hinh2 = rs.getString("Hinh2");
               BufferedImage img1 = ImageIO.read(new File("src\\matnguoi\\" + Hinh1));
            BufferedImage img = ImageIO.read(new File("src\\soxe\\" + Hinh2));
          Image dmg = img1.getScaledInstance(lblHinh1.getWidth(), lblHinh1.getHeight(), Image.SCALE_SMOOTH);
            Image  dmg1 = img.getScaledInstance(lblHinh2.getWidth(), lblHinh2.getHeight(), Image.SCALE_SMOOTH);
           ImageIcon icon = new ImageIcon(dmg);
         lblHinh1.setIcon(icon);
         ImageIcon icon1 = new ImageIcon(dmg1);
        lblHinh2.setIcon(icon1);
    
        }
        } 
          catch (Exception e) {
            System.out.println(e);
        }
     
    }
          
          
          
       public void loadDataToCbo1() {
       
     try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from QuanLiXe ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cboVeXe1.addItem(rs.getString("MaVeXe"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
       
          public void selectItem1() {
        try {
         Connection con =  new MyConnection().getConnect();           
            String sql = "select * from QuanLiXe where MaVeXe = ?"; 
              String ma = (String) cboVeXe1.getSelectedItem();
            PreparedStatement stm = con.prepareStatement(sql);
          stm.setString(1,ma);
           ResultSet rs = stm.executeQuery();     
          while (rs.next()) {
                         
        
           txtngayVao1.setText(String.valueOf(rs.getDate("NgayVao")));
         
          Hinh1 = rs.getString("Hinh1");
          Hinh2 = rs.getString("Hinh2");
               BufferedImage img1 = ImageIO.read(new File("src\\matnguoi\\" + Hinh1));
            BufferedImage img = ImageIO.read(new File("src\\soxe\\" + Hinh2));
          Image dmg = img1.getScaledInstance(lblHinh1.getWidth(), lblHinh1.getHeight(), Image.SCALE_SMOOTH);
            Image  dmg1 = img.getScaledInstance(lblHinh2.getWidth(), lblHinh2.getHeight(), Image.SCALE_SMOOTH);
           ImageIcon icon = new ImageIcon(dmg);
         lblHinh3.setIcon(icon);
         ImageIcon icon1 = new ImageIcon(dmg1);
        lblHinh4.setIcon(icon1);
    
        }
        } 
          catch (Exception e) {
            System.out.println(e);
        }
     
    }


  
    public QuanLiXe() {
        initComponents();
         setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                loadDataToCbo();
                loadDataToCbo1();
                showList();

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtVeXe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtngayvao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboloai = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rdoDinhCu = new javax.swing.JRadioButton();
        rdoVangLai = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        btnThoat5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cboVeXe = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        lblHinh1 = new javax.swing.JLabel();
        btnUpDate = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cboVeXe1 = new javax.swing.JComboBox<>();
        btnsearch1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtngayVao1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblHinh3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtngayra = new javax.swing.JTextField();
        btnThoat1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblHinh4 = new javax.swing.JLabel();
        btncamera = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        lblHinh2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblxe = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Mã vé xe");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ngày vào");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Loại xe");

        cboloai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ô tô", "Xe Máy" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Khách Hàng");

        buttonGroup1.add(rdoDinhCu);
        rdoDinhCu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        rdoDinhCu.setText("Định cư");

        buttonGroup1.add(rdoVangLai);
        rdoVangLai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        rdoVangLai.setText("Vãng lai");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Hình");

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnThoat5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new.png"))); // NOI18N
        btnThoat5.setText("NEW");

        jPanel3.setBackground(new java.awt.Color(255, 0, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboVeXe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboVeXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thẻ Xe" }));

        btnsearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/timkiem.png"))); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboVeXe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVeXe)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblHinh1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        lblHinh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinh1MouseClicked(evt);
            }
        });

        btnUpDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnUpDate.setText("UPDATE");
        btnUpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpDateActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboVeXe1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboVeXe1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thẻ Xe" }));

        btnsearch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/timkiem.png"))); // NOI18N
        btnsearch1.setText("Search");
        btnsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cboVeXe1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVeXe1)
                    .addComponent(btnsearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Ngày vào");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Sau");

        lblHinh3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        lblHinh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinh3MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Trước");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Ngày ra");

        btnThoat1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat1.setText("XUẤT XE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("HÌNH ĐỐI CHIẾU");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHinh4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        lblHinh4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinh4MouseClicked(evt);
            }
        });

        btncamera.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/camera.png"))); // NOI18N
        btncamera.setText("CAMERA");
        btncamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncameraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblHinh3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHinh4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncamera)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtngayVao1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(txtngayra)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtngayVao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtngayra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncamera, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(35, 35, 35)
                        .addComponent(lblHinh3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHinh4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        btnsave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsave.setText("XE VÀO");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        lblHinh2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        lblHinh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinh2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtVeXe, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(376, 376, 376))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtngayvao, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnUpDate)
                                        .addComponent(lblHinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThoat5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblHinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnsave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btndelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(70, 70, 70)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rdoVangLai)
                                        .addComponent(cboloai, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(81, 81, 81)))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDinhCu))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVeXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboloai))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoDinhCu)
                                .addComponent(rdoVangLai)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtngayvao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7)
                        .addGap(51, 51, 51)
                        .addComponent(lblHinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndelete)
                    .addComponent(btnThoat5))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpDate)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Nhà xe", jPanel1);

        tblxe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblxe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Mã thẻ xe", "Loại xe", "Khách hàng", "Ngày vào", "Hình 1", "Hình 2", "Hình 3", "Hình 4", "Ngày ra"
            }
        ));
        tblxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblxeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblxe);
        if (tblxe.getColumnModel().getColumnCount() > 0) {
            tblxe.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 278, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("QUẢN LÍ XE ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jLabel9)))
                .addGap(0, 113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
   this.selectItem(); 
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearch1ActionPerformed
this.selectItem1();
    }//GEN-LAST:event_btnsearch1ActionPerformed

    private void btncameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncameraActionPerformed
                hinhgui t = new hinhgui();
   t.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   t.setVisible(true);
   


      
    }//GEN-LAST:event_btncameraActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        QuanLiXeDao qlxDAO = new QuanLiXeDao();
        int kq = qlxDAO.deteleItem(txtid.getText());
        if (kq == -1) {
            JOptionPane.showMessageDialog(this, "không kết nối được.");
        } else if (kq == 0) {
            JOptionPane.showMessageDialog(this, "xóa thất bại.");
        } else if (kq == 1) {
            JOptionPane.showMessageDialog(this, "xóa thành công.");
        }

        
        showList();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
       QLXe vx = new QLXe();
      
    vx.setId(txtid.getText());
          vx.setVeXe(txtVeXe.getText());
        vx.setLoaiXe(cboloai.getSelectedItem().toString());
         vx.setNgayVao(DateHelper.toDate(txtngayvao.getText()));
                 
     if (rdoVangLai.isSelected()==true)
        {
            vx.setLoaiKH(0);
        }
        else
        {
            vx.setLoaiKH(1);
        }
       
         vx.setHinh1(Hinh1);
 vx.setHinh2(Hinh2);

     vx.setNgayRa(DateHelper.toDate(txtngayra.getText()));
    

     QuanLiXeDao xl = new QuanLiXeDao();
        int kq = xl.insertItem(vx);
        if (kq == -1) {
            JOptionPane.showMessageDialog(this, "Không kết nối được với database!");
        } else if (kq == 1) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        } else if (kq == 0) {
            JOptionPane.showMessageDialog(this, "Lỗi! Hãy xem lại bạn có nhập sai trường nào không!");
        }
      
   
                      showList();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void lblHinh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinh1MouseClicked
     chonHinh();
    }//GEN-LAST:event_lblHinh1MouseClicked

    private void lblHinh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinh2MouseClicked
      chonHinh1();
    }//GEN-LAST:event_lblHinh2MouseClicked

    private void lblHinh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinh3MouseClicked
fileimage3= new QuanLiXeDao().chonAnh(lblHinh3);
    }//GEN-LAST:event_lblHinh3MouseClicked

    private void lblHinh4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinh4MouseClicked
 fileimage4= new QuanLiXeDao().chonAnh1(lblHinh4);
    }//GEN-LAST:event_lblHinh4MouseClicked

    private void btnUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateActionPerformed
       QLXe vx = new QLXe();
          
        vx.setId(txtid.getText());

        vx.setVeXe(txtVeXe.getText());
        vx.setLoaiXe(cboloai.getSelectedItem().toString());
         vx.setNgayVao(DateHelper.toDate(txtngayvao.getText()));
                 
     if (rdoVangLai.isSelected()==true)
        {
            vx.setLoaiKH(0);
        }
        else
        {
            vx.setLoaiKH(1);
        }
     
       
       vx.setHinh1(Hinh1);
 vx.setHinh2(Hinh2);
      vx.setHinh1(fileimage1);
        vx.setHinh2(fileimage2);
        vx.setHinh3(Hinh1);
         vx.setHinh4(Hinh2);
         vx.setNgayRa(DateHelper.toDate(txtngayra.getText()));
      
        QuanLiXeDao xl = new QuanLiXeDao();
        int kq = xl.update(vx);
        if (kq == -1) {
            JOptionPane.showMessageDialog(this, "Không kết nối được với database!");
        } else if (kq == 1) {
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } else if (kq == 0) {
            JOptionPane.showMessageDialog(this, "Lỗi! Hãy xem lại bạn có nhập sai trường nào không!");
        }
        showList();
    }//GEN-LAST:event_btnUpDateActionPerformed

    private void tblxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblxeMouseClicked
       try {
            hienthi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblxeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLiXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiXe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat1;
    private javax.swing.JButton btnThoat5;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JButton btncamera;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnsearch1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboVeXe;
    private javax.swing.JComboBox<String> cboVeXe1;
    private javax.swing.JComboBox<String> cboloai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHinh1;
    private javax.swing.JLabel lblHinh2;
    private javax.swing.JLabel lblHinh3;
    private javax.swing.JLabel lblHinh4;
    private javax.swing.JRadioButton rdoDinhCu;
    private javax.swing.JRadioButton rdoVangLai;
    private javax.swing.JTable tblxe;
    private javax.swing.JTextField txtVeXe;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtngayVao1;
    private javax.swing.JTextField txtngayra;
    private javax.swing.JTextField txtngayvao;
    // End of variables declaration//GEN-END:variables
}

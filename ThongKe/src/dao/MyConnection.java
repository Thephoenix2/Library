/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

/**
 *
 * @author home
 */
public class MyConnection {

    public MyConnection() {
    }

    public Connection getConnect() {
        Connection cn = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyBaiGiuXe";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, "sa", "1");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }
}

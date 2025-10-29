/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_enam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo IP 330-14IKB
 */
public class Koneksi {

    private static final String URL = "jdbc:postgresql://localhost:5432/Kuliah_PBO";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ZayZiya03";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("YESSSS, Koneksi berhasil!");
        } catch (SQLException e) {
            System.out.println("NOOOO, Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}

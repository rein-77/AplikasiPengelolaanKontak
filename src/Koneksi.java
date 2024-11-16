import java.sql.*;
import java.io.File;

public class Koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                // Create database directory if it doesn't exist
                File dbDir = new File("database");
                if (!dbDir.exists()) {
                    dbDir.mkdir();
                }
                
                String url = "jdbc:sqlite:database/db_kontak.db";
                koneksi = DriverManager.getConnection(url);
                System.out.println("Koneksi ke database berhasil!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error Koneksi Database: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
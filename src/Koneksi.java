import java.sql.*;
import java.io.File;

public class Koneksi {
    // Variabel untuk menyimpan koneksi database
    private static Connection koneksi;
    
    /**
     * Method untuk mendapatkan koneksi ke database SQLite
     * @return object Connection untuk koneksi ke database
     */
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                // Load driver SQLite
                Class.forName("org.sqlite.JDBC");
                
                // Buat direktori database jika belum ada
                File dbDir = new File("database");
                if (!dbDir.exists()) {
                    dbDir.mkdir();
                }
                
                // Buat koneksi ke database
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
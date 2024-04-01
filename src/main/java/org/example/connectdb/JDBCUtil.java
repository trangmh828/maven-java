package org.example.connectdb;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;

        Driver driver = null;
        try {
            // Đăng ký MySQL Driver với DriverManager
            driver = new Driver();
            DriverManager.registerDriver(driver);

            // Các thông số
            String url = "jdbc:mySQL://localhost:33063/java_test";
            String username = "root";
            String password = "Trang123456a@";

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData databaseMetaData = c.getMetaData();
                System.out.println(databaseMetaData.getDatabaseProductName());
                System.out.println(databaseMetaData.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

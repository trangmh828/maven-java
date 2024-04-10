package org.example.connectdb1;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        String server = "localhost";
        String port = "33063";
        String db_name = "java_test";

        try {
            // register driver
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            // Cac thong so
            String url = "jdbc:mysql://" + server + ":" + port + "/" + db_name;
            String username = "root";
            String password = "Trang123456a@";

            // tao ket noi
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection.getMetaData().getDatabaseProductName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void disConnect (Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

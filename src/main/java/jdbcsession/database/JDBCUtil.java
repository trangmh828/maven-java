package jdbcsession.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        Driver driver = null;
        String server = "localhost";
        String port = "33063";
        String db_name = "nhasach";

        try {
            // register Driver
            driver = new Driver();
            DriverManager.registerDriver(driver);

            // cac thong so
            String url = "jdbc:mysql://" + server + ":" + port + "/" + db_name;
            String username = "root";
            String password = "Trang123456a@";

            // ket noi
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void disConnect(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

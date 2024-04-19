package jdbcsession.database;

import com.mysql.cj.jdbc.Driver;
import fileinjava.FileInJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        Driver driver = null;
//        String server = "localhost";
//        String port = "33063";
//        String db_name = "nhasach";

        // read file Config DB
        String CONFIG_FILE_NAME = "configdb.properties";
        Properties properties = JDBCUtil.readFileConfigDB(CONFIG_FILE_NAME);
        String server = properties.getProperty("server");
        String port = properties.getProperty("port");
        String db_name = properties.getProperty("db.name");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        try {

            // register Driver
            driver = new Driver();
            DriverManager.registerDriver(driver);

            // cac thong so
            String url = "jdbc:mysql://" + server + ":" + port + "/" + db_name;
//            String username = "root";
//            String password = "Trang123456a@";
            System.out.println(url);

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

    // read file Config DB
    public static Properties readFileConfigDB(String fileConfigDB) {
        try {
            InputStream inputStream = FileInJava.class.getClassLoader().getResourceAsStream(fileConfigDB);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

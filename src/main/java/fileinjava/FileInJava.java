package fileinjava;

import com.mysql.cj.jdbc.Driver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileInJava {
    public static void main(String[] args) {
        FileInJava fileInJava = new FileInJava();
        fileInJava.loadPropertiesFromPath("D:\\Downloads 20240314\\config.properties");
        fileInJava.loadPropertiesFromClassPath("config.properties");
        fileInJava.loadPropertiesToMap("config.properties");
        var config = fileInJava.loadPropertiesToConfig("config.properties");
        var config1 = fileInJava.getConnection("configdb.properties");
        System.out.println("DONE");
    }

    /**
     * Read file by String path
     * @param path
     * @return properties
     */
    public Properties loadPropertiesFromPath (String path) {
        try {
            InputStream inputStream = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read file by file in directory resources
     * @param name
     * @return properties
     */
    public Properties loadPropertiesFromClassPath(String name) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read file and return Map object
     * @param name
     * @return
     */
    public Map<String, String> loadPropertiesToMap(String name) {
        try {
            Map<String, String> configMap = new HashMap<>();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
            Properties properties = new Properties();
            properties.load(inputStream);
            for(Object key : properties.keySet()) {
                configMap.put(key.toString(),properties.getProperty(key.toString()));
            }
            return configMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read file and return Object config

    /**
     * Read file and return Object config
     * @param name
     * @return Config
     */
    public Config loadPropertiesToConfig(String name) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
            Properties properties = new Properties();
            properties.load(inputStream);
            return Config.builder()
                    .db_url(properties.getProperty("db.url"))
                    .db_pass(properties.getProperty("db.pass"))
                    .db_user(properties.getProperty("db.user"))
                    .web_url(properties.getProperty("web.url"))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(String fileConfigDB) {
        Connection connection = null;
        Driver driver = null;
        String server = "localhost";
        String port = "33063";
        String db_name = "nhasach";
        Properties properties = FileInJava.readFileConfigDB("configdb.properties");

        try {
            // read file Config

            // register Driver
            driver = new Driver();
            DriverManager.registerDriver(driver);

            // cac thong so
            String url = "jdbc:mysql://" + server + ":" + port + "/" + db_name;
            String username = "root";
            String password = "Trang123456a@";

            System.out.println(properties.getProperty("server"));
            System.out.println(properties.getProperty("port"));
            System.out.println(properties.getProperty("db.name"));
            System.out.println(properties.getProperty("username"));
            System.out.println(properties.getProperty("password"));

            // ket noi
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

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

    // Object
    @Builder
    @AllArgsConstructor
    public static class Config {
        private String db_url;
        private String db_pass;
        private String db_user;
        private String web_url;

        public Config() {

        }
    }

}

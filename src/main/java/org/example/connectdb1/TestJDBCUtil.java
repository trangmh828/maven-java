package org.example.connectdb1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) {
        try {
            // Buoc 1: Tao ket noi
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao statement
            Statement statement = connection.createStatement();

            // Buoc 3: Thuc thi 1 cau lenh SQL
            String sql = "INSERT INTO `java_test`.`persons` (`person_id`, `last_name`, `first_name`, `gender`, `dob`, `income`) " +
                    "VALUES ('4', 'Hong', 'Hae In', 'F', '1992-10-19', '25000000')";

            // Buoc 4: Kiem tra
            int check = statement.executeUpdate(sql);

            if (check > 0) {
                System.out.println("Thuc thi thanh cong");
            } else {
                System.out.println("Thuc thi that bai");
            }

            // Buoc 5: Ngat ket noi
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

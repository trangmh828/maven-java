package jdbcsession.test;

import jdbcsession.database.JDBCUtil;

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

            // Buoc 3: Cau lenh sql
            String sql = "INSERT INTO `nhasach`.`khachhang` (`id`, `hoVaTen`, `ngaySinh`, `diaChi`) " +
                    "VALUES ('3', 'Nguyen Van A', '1994-10-19 04:34:33', 'Hanoi')";
            int check = statement.executeUpdate(sql);

            // Buoc 4: Xu ly ket qua
            if (check > 0) {
                System.out.println("Thanh cong");
            } else {
                System.out.println("That bai");
            }

            // Buoc 5: Ket thuc
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

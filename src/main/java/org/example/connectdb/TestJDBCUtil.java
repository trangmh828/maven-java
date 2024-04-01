package org.example.connectdb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) {
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            Statement st = connection.createStatement();

            // Bước 3: Thực thi 1 câu lệnh SQL
            String sql1 = "Select * from users";
            String sql = "INSERT INTO `java_test`.`users` (`id`, `username`, `password`, `email`) " +
                    "VALUES ('5', 'trang', '12345', 'trang@gmail.com')";

            int check = st.executeUpdate(sql);

            // Bước 4: Xử lý kết quả
            System.out.println("So dong thay doi " + check);
            if (check > 0) {
                System.out.println("Them du lieu thanh cong");
            } else {
                System.out.println("Them du lieu that bai");
            }


            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

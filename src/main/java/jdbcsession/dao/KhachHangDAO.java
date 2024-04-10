package jdbcsession.dao;

import jdbcsession.database.JDBCUtil;
import jdbcsession.model.KhachHang;
import jdbcsession.model.Sach;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang khachHang) {
        int ketQua = 0;

        try {
            // Buoc 1: Ket noi JDBC
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: SQL
            String sql = "INSERT INTO khachhang(id, hoVaTen, ngaySinh, diaChi) " +
                    "VALUES (" + khachHang.getId() + ", '" + khachHang.getHoVaTen() + "', '"
                    + khachHang.getNgaySinh() + "', '" + khachHang.getDiaChi() + "')";
            ketQua = statement.executeUpdate(sql);

            // Buoc 4:
            System.out.println("Cau lenh sql: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi");

            // Buoc 5: close connection
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int update(KhachHang khachHang) {
        int ketQua = 0;

        try {
            // Buoc 1: Ket noi JDBC
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: SQL
            String sql = "UPDATE khachhang " +
                        "SET "
                    + "hoVaTen = '" + khachHang.getHoVaTen() + "', "
                    + "ngaySinh = '" + khachHang.getNgaySinh() + "', "
                    + "diaChi = '" + khachHang.getDiaChi() + "'"
                    + "WHERE id = " + khachHang.getId();
            ketQua = statement.executeUpdate(sql);

            // Buoc 4:
            System.out.println("Cau lenh sql: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi");

            // Buoc 5: close connection
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int delete(KhachHang khachHang) {
        int ketQua = 0;

        try {
            // Buoc 1: Ket noi JDBC
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: SQL
            String sql = "DELETE FROM khachhang "
                    + "WHERE id = " + khachHang.getId();
            ketQua = statement.executeUpdate(sql);

            // Buoc 4:
            System.out.println("Cau lenh sql: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi");

            // Buoc 5: close connection
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM khachhang";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hoVaTen = resultSet.getString("hoVaTen");
                Date ngaySinh = resultSet.getDate("ngaySinh");
                String diaChi = resultSet.getString("diaChi");

                KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
                ketQua.add(khachHang);
            }

            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public KhachHang selectById(KhachHang khachHang) {
        KhachHang ketQua = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM khachhang WHERE id = " + khachHang.getId();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hoVaTen = resultSet.getString("hoVaTen");
                Date ngaySinh = resultSet.getDate("ngaySinh");
                String diaChi = resultSet.getString("diaChi");

                ketQua = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        ArrayList<KhachHang> ketQua = new ArrayList<>();

        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM khachhang WHERE " + condition;
            System.out.println("Cau lenh sql: " + sql);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hoVaTen = resultSet.getString("hoVaTen");
                Date ngaySinh = resultSet.getDate("ngaySinh");
                String diaChi = resultSet.getString("diaChi");

                KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
                ketQua.add(khachHang);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}

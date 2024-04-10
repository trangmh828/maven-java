package jdbcsession.dao;

import jdbcsession.database.JDBCUtil;
import jdbcsession.model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int ketQua = 0;
        try {
            // Buoc 1: ket noi den CSDL
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao doi tuong statement
            Statement statement = connection.createStatement();

            // Buoc 3: Thuc thi cau lenh SQL
            String sql = "INSERT INTO sach(id, tenSach, giaBan, namXuatBan) " +
                    "VALUES ('" + sach.getId() + "', '" + sach.getTenSach() + "'," + sach.getGiaBan() + ",'" +
                    sach.getNamXuatBan() + "')";

            ketQua = statement.executeUpdate(sql);

            // Buoc 4:
            System.out.println("Cau lenh sql: " + sql);

            System.out.println("Co " + ketQua + " dong bi thay doi");

            // Buoc 5: ngat ket noi
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int update(Sach sach) {
        int ketQua = 0;
        try {
            // Buoc 1: ket noi den CSDL
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao doi tuong statement
            Statement statement = connection.createStatement();

            // Buoc 3: Thuc thi cau lenh SQL
            String sql = "UPDATE sach " +
                    "SET " +
                    " tenSach = '" + sach.getTenSach() + "'" +
                    ", giaBan = " + sach.getGiaBan() +
                    ", namXuatBan = '" + sach.getNamXuatBan() + "'" +
                    " WHERE id = '" + sach.getId() +"'";

            ketQua = statement.executeUpdate(sql);

            // Buoc 4:
            System.out.println("Cau lenh sql: " + sql);

            System.out.println("Co " + ketQua + " dong bi thay doi");

            // Buoc 5: ngat ket noi
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int delete(Sach sach) {
        int ketQua = 0;
        try {
            // Buoc 1: ket noi den CSDL
            Connection connection = JDBCUtil.getConnection();

            // Buoc 2: Tao doi tuong statement
            Statement statement = connection.createStatement();

            // Buoc 3: Thuc thi cau lenh SQL
            String sql = "DELETE FROM sach " +
                    " WHERE id = '" + sach.getId() +"'";

            ketQua = statement.executeUpdate(sql);

            // Buoc 4:
            System.out.println("Cau lenh sql: " + sql);

            System.out.println("Co " + ketQua + " dong bi thay doi");

            // Buoc 5: ngat ket noi
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<>();

        // buoc 1: ket noi jdbc
        try {
            Connection connection = JDBCUtil.getConnection();

            // buoc 2: tao doi tuong statement
            Statement statement = connection.createStatement();

            // buoc 3: sql
            String sql = "SELECT * FROM sach";
            System.out.println("Cau lenh sql: " + sql);
            ResultSet resultSet = statement.executeQuery(sql);

            // buoc 4:
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String tenSach = resultSet.getString("tenSach");
                float giaBan = resultSet.getFloat("giaBan");
                int namXuatBan = resultSet.getInt("namXuatBan");

                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(sach);
            }

            // buoc 5: ngat ket noi
            JDBCUtil.disConnect(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public Sach selectById(Sach sach) {
        Sach ketQua = null;

        try {
            // ket noi connection
            Connection connection = JDBCUtil.getConnection();

            // Tao doi tuong statement
            Statement statement = connection.createStatement();

            // Cau lenh sql
            String sql = "SELECT * FROM sach WHERE id = '" + sach.getId() + "'";
            System.out.println("Cau lenh sql: " + sql);
            ResultSet resultSet = statement.executeQuery(sql);

            // buoc 4: trien khai
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String tenSach = resultSet.getString("tenSach");
                float giaBan = resultSet.getFloat("giaBan");
                int namXuatBan = resultSet.getInt("namXuatBan");

                ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
            }




            // Buoc 5: ngat ket noi
            JDBCUtil.disConnect(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> sach = new ArrayList<>();

        try {
            Connection connection = JDBCUtil.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM sach WHERE " + condition;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String tenSach = resultSet.getString("tenSach");
                float giaBan = resultSet.getFloat("giaBan");
                int namXuatBan = resultSet.getInt("namXuatBan");

                Sach sach1 = new Sach(id, tenSach, giaBan, namXuatBan);
                sach.add(sach1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sach;
    }
}

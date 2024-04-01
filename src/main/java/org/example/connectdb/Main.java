package org.example.connectdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        JDBCUtil.printInfo(connection);

        ArrayList<Customers> customers = getCustomersList(connection);

        for (int i = 0; i < customers.size(); i++) {
            System.out.println("ID: " + customers.get(i).getId());
            System.out.println("Name: " + customers.get(i).getName());
            System.out.println("Phone: " + customers.get(i).getPhone());
            System.out.println("Point: " + customers.get(i).getPoint());
            System.out.println("Address: " + customers.get(i).getAddress());
            System.out.println("Birthday: " + customers.get(i).getBirthday());
            System.out.println("Created At: " + customers.get(i).getCreated_at());
            System.out.println("--------------------");
        }

        System.out.println("Sum of point = " + getSumPoint(customers));

        JDBCUtil.closeConnection(connection);
    }

    public static ArrayList<Customers> getCustomersList(Connection c) {
        ArrayList<Customers> customersArrayList = new ArrayList<>();
        Statement stm = null;
        String sql = "SELECT * FROM customers";
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Customers customers = new Customers(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getInt("point"), rs.getString("address"),
                        rs.getString("birthday"), rs.getString("created_at"));
                customersArrayList.add(customers);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customersArrayList;
    }

    /**
     * Tính tổng số point mà các customer đó có
     * @param customers
     * @return
     */
    public static double getSumPoint(ArrayList<Customers> customers) {
        int sumPoint = 0;
        for (int i = 0; i < customers.size(); i++) {
            sumPoint += customers.get(i).getPoint();
        }
        return sumPoint;
    }
}

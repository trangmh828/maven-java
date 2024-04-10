package jdbcsession.test;

import jdbcsession.dao.KhachHangDAO;
import jdbcsession.model.KhachHang;
import java.sql.Date;
import java.util.ArrayList;


public class TestKhachHangDAO {
    public static void main(String[] args) {
        /* Test Insert */
        /*
        String dateOfBirth = "2000-02-02";
        Date date = Date.valueOf(dateOfBirth);
        for (int i = 5; i < 20; i++) {
            KhachHang khachHang = new KhachHang(i, "Kim Ji Won " + i, date, "Geong gi");
            KhachHangDAO.getInstance().insert(khachHang);
        }
        */

        /* Test Update */
        /*
        String dateOfBirth = "1992-10-19";
        Date date = Date.valueOf(dateOfBirth);

        KhachHang khachHang = new KhachHang(0, "Kim Ji Won xinh nhat the gioi" , date, "Geumcheon-gu");
        KhachHangDAO.getInstance().update(khachHang);
        */

        /* Test Delete */
        /*
        for (int i = 5; i < 20; i++) {
            KhachHang khachHang = new KhachHang(i);
            KhachHangDAO.getInstance().delete(khachHang);
        }

         */

        /* Test SELECT ALL */
        /*
        ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectAll();
        for (KhachHang khachHang : khachHangs) {
            System.out.println(khachHang.toString());
        }

         */

        /* Test SELECT BY ID */
        /*
        KhachHang khachHang = new KhachHang(0);
        KhachHang khachHangById = KhachHangDAO.getInstance().selectById(khachHang);
        System.out.println(khachHangById.toString());
         */

        /* Test SELECT BY CONDITION */
        String condition = "Year(ngaySinh) < 1996";
        ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectByCondition(condition);
        for (KhachHang khachHang : khachHangs) {
            System.out.println(khachHang.toString());
        }
    }
}

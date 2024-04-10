package jdbcsession.test;

import jdbcsession.dao.SachDAO;
import jdbcsession.model.Sach;

import java.util.ArrayList;

public class TestSachDAO {
    public static void main(String[] args) {
         /* Test Insert */
        /*
         Sach sach1 = new Sach("LTJV", "Lap trinh Java", 50000, 2025);
         Sach sach2 = new Sach("LTC", "Lap trinh C", 20000, 2024);

           for (int i = 0; i < 5; i++) {
              Sach sach = new Sach("LT " + i, "Lap trinh PHP " + i, 35000, 2030);
                SachDAO.getInstance().insert(sach);
           }
            */

        /* Test Update */
        /*
        Sach sachUpdate = new Sach("LT 99", "Lap trinh PHP NEW", 50000, 2025);
        SachDAO.getInstance().update(sachUpdate);
        */

        /* Delete SQL */
        /*
        for (int i = 0; i < 100; i++) {
            Sach sach = new Sach("LT " + i, "Lap trinh PHP " + i, 35000, 2030);
            SachDAO.getInstance().delete(sach);
        }
         */

        /* SELECT ALL */
        /*
        ArrayList<Sach> sachs = SachDAO.getInstance().selectAll();
        for (Sach sach : sachs) {
            System.out.println(sach.toString());
        }
        */

        /* SELECT BY ID */
        /*
        Sach sachAll = new Sach();
        sachAll.setId("LT 3");
        Sach sachs = SachDAO.getInstance().selectById(sachAll);
        System.out.println(sachs.toString());
         */

        /* SELECT BY CONDITION */
        /*
        ArrayList<Sach> sachArrayList = SachDAO.getInstance().selectByCondition("giaBan < 35000");
        for (Sach sach : sachArrayList) {
            System.out.println(sach.toString());
        }

         */
    }
}

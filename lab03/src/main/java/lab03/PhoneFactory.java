package lab03;

import lab03.dao.ManufactureDAO;
import lab03.dao.PhoneDAO;
import lab03.domain.Manufacture;
import lab03.domain.Phone;

public class PhoneFactory {
    public static void main(String[] args) {
        // Tạo đối tượng DAO cho cả manufacture và phone
        ManufactureDAO manufactureDAO = ManufactureDAO.getInstance();
        PhoneDAO phoneDAO = PhoneDAO.getInstance();

        // Thêm dữ liệu vào bảng manufacture
        Manufacture manufacture1 = new Manufacture("Marcus Rasford", "Manchester", 109);
        Manufacture manufacture2 = new Manufacture("Lord Bener", "US", 80);
        manufactureDAO.add(new Manufacture("Marcus Rasford","Manchester",109));
        manufactureDAO.add(manufacture1);
        manufactureDAO.add(manufacture2);
        System.out.println(manufactureDAO.readAll());
        System.out.println(manufactureDAO.read(1));
        System.out.println(manufactureDAO.update(new Manufacture("Marcus Lord","US",70)));
        System.out.println(manufactureDAO.delete(3));

        // Thêm dữ liệu vào bảng phone
        Phone phone = new Phone("Iphone 15",8000000,"Black","America",600);
        Phone phone1 = new Phone("Iphone 20",80000000,"Pink","America",600);
        Phone phone3 = new Phone("Iphone 20",80000000,"Pink","America",600);
        phoneDAO.add(phone);
        phoneDAO.add(phone1);
        phoneDAO.add(phone3);

        // Hiển thị dữ liệu từ cả hai bảng
        System.out.println(manufactureDAO.readAll());
        System.out.println(phoneDAO.readAll());

        //             Test Query
        System.out.println(manufactureDAO.checkOver100Emp());
        System.out.println(manufactureDAO.sumAllEmployee());
        System.out.println(manufactureDAO.allManuInUS());
        //             Test Query
        System.out.println(phoneDAO.highestPrice());
        System.out.println(phoneDAO.sorted());
        System.out.println(phoneDAO.greater50M());
        System.out.println(phoneDAO.pinkColorAndGt15M());
        // Đóng kết nối và giải phóng tài nguyên
        manufactureDAO.close();
        phoneDAO.close();
    }
}
package lab03;
import lab03.dao.PhoneDAO;
import lab03.domain.Phone;
public class PhoneFactory {
    public static void main(String[] args) {
        System.out.println("them 6 phone vao data");
        PhoneDAO phoneDAO = new PhoneDAO();
        phoneDAO.add(new Phone("iPhone 13 Pro Max", 13000, "Deep Blue", "VN", 20));
        phoneDAO.add(new Phone("iPhone 16 Pro Max", 16000000, "Pink", "US", 1));
        phoneDAO.add(new Phone("iPhone 14", 799, "Blue", "USB", 10));
        phoneDAO.add(new Phone("iPhone 14 Plus", 899, "Deep Blue", "USB", 20));
        phoneDAO.add(new Phone("iPhone 14 Pro", 33000000, "Pink", "VN", 30));
        phoneDAO.add(new Phone("iPhone 14 Pro Max", 53000000, "Deep Purple", "VN", 40));
        System.out.println("------------------------------------------------------------------");
    }
}

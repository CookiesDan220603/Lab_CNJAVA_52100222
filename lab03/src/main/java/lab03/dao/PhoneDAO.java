package lab03.dao;
import java.util.List;

import javax.persistence.Query;
import lab03.domain.Phone;
import lab03.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
public class PhoneDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();
    public boolean add(Phone phone) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
            return true;
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }
}

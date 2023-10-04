package lab03.dao;

import lab03.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class ManufacturerDAO {
    Session session = HibernateUtil.getSessionFactory().openSession();
}

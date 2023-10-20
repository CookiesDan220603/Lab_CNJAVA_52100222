package main.DAO;

import utils.HibernateUtils;
import main.Model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {
    private static Session session;
    private static Transaction transaction;

    public static ProductDAO getInstance() {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return new ProductDAO();
    }

    public boolean add(Product item) {
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id) {
        try{
            transaction = session.beginTransaction();
            Product product =  session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public List<Product> readAll() {
        if (session != null && session.isOpen()) {
            return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
        }
        return null; // Hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu của ứng dụng của bạn
    }

    public void close() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
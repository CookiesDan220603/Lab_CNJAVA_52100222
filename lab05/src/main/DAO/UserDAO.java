package main.DAO;

import main.Model.User;
import main.Model.User;
import utils.HibernateUtils;
import org.hibernate.*;
public class UserDAO {
    private static Session session;
    private static Transaction transaction;
    public static UserDAO getInstance() {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = null;
        return new UserDAO();
    }
    public boolean add(User item) {
        try{
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
    public User read(String username) {
        try{
            transaction = session.beginTransaction();
            User user = session.get(User.class,username);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return new User();
        }
    }
    public void  close(){
        session.close();
    }
}

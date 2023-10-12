package lab03.dao;
import lab03.domain.Manufacture;
import lab03.domain.Phone;
import lab03.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Objects;
public class PhoneDAO implements Repository<Phone, String>{
    private static Session session;
    private static Transaction transaction;
    public static PhoneDAO getInstance() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;
        return new PhoneDAO();
    }
    @Override
    public boolean add(Phone item) {
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

    @Override
    public List<Phone> readAll() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
        query.from(Phone.class);
        return session.createQuery(query).getResultList();
    }

    @Override
    public Phone read(String id) {
        try{
            transaction = session.beginTransaction();
            Phone phone = session.byId(Phone.class).getReference(id);
            transaction.commit();
            return phone;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Manufacture read(int id) {
        return null;
    }

    @Override
    public boolean update(Phone item) {
        if(Objects.equals(null, item)){
            return false;
        }
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

    @Override
    public boolean delete(String id) {
        try{
            transaction = session.beginTransaction();
            Phone phone =  session.get(Phone.class, id);
            if (phone != null) {
                session.delete(phone);
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

    @Override
    public boolean delete(int id) {
        return false;
    }

    public void close(){
        session.close();
    }
    public List<Phone> highestPrice(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone WHERE " +
                "price = (SELECT MAX(Price) FROM Phone)",Phone.class);
        return query.getResultList();
    }
    public List<Phone> sorted(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone " +
                "ORDER BY country ASC, price DESC",Phone.class);
        return query.getResultList();
    }
    public List<Phone> greater50M(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone " +
                "where price >50000000",Phone.class);
        return query.getResultList();
    }
    public List<Phone> pinkColorAndGt15M(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone " +
                "where price >1500000 and color = 'pink'",Phone.class);
        if (query.getResultList().size()==0) return null;
        return query.getResultList();
    }
}
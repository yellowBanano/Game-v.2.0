package by.myself.dao;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseDao<T> {

    public  boolean save(Session session, T t) {
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        return true;
    }

    public  boolean update(Session session, T t) {
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        return true;
    }

    public  boolean delete(Session session, T t) {
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        return true;
    }

    public abstract List<T> findAll(Session session);

    public abstract T findById(Session session, Long id);
}

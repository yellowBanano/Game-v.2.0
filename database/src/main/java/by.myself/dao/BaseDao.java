package by.myself.dao;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseDao<T> {

    public void save(Session session, T t) {
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
    }

    public void update(Session session, T t) {
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
    }

    public void delete(Session session, T t) {
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
    }

    public List<T> findAll(Session session) {
        session.beginTransaction();
        List<T> resultList = session.createQuery("select e from " + getEntityClass().getSimpleName() + " e", getEntityClass())
                .getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    public T findById(Session session, Long id) {
        session.beginTransaction();
        List<T> resultList = session.createQuery("select e from " + getEntityClass().getSimpleName() + " e where e.id = " + id, getEntityClass())
                .getResultList();
        session.getTransaction().commit();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    protected abstract Class<T> getEntityClass();

}

package by.myself.support.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionGetter {

    public static Object getData(Class<?> inputClass, Long id) {
        SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        Session session = SESSION_FACTORY.openSession();
        Object returnObject = session.get(inputClass, id);
        session.close();
        SESSION_FACTORY.close();
        return returnObject;
    }
}

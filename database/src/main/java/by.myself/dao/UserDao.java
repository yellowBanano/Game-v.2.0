package by.myself.dao;

import by.myself.entities.QUser;
import by.myself.entities.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends BaseDao<User> {

    private static UserDao INSTANCE;

    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    private UserDao() {
    }

    @Override
    public List<User> findAll(Session session) {
        session.createQuery("select u from User u", User.class).getResultList();
        JPAQuery<User> query = new JPAQuery<>(session);
        QUser user = QUser.user;
        query.select(user)
                .from(user);
        return query.fetchResults().getResults();
    }

    @Override
    public User findById(Session session, Long id) {
        JPAQuery<User> query = new JPAQuery<>();
        QUser user = QUser.user;
        query.select(user)
                .from(user)
                .where(user.id.eq(id));
        return query.fetchOne();
    }
}

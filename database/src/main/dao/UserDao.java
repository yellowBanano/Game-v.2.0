package dao;

import entities.User;
import support_entities.SessionGetter;

public class UserDao {
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

    public User getUser(Long id) {
        return (User) SessionGetter.getData(User.class, id);
    }
}

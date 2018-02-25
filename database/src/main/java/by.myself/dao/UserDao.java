package by.myself.dao;

import by.myself.entities.User;

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
    protected Class<User> getEntityClass() {
        return User.class;
    }
}

package by.myself;

import by.myself.dao.UserDao;
import by.myself.entities.User;

public class UserService {

    private static UserService INSTANCE;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    private UserService() {
    }

    public User getUser() {
        return UserDao.getInstance().getUser(1L);
    }
}

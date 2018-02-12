package by.myself;

import by.myself.dao.UserDao;

public class UserService {

    private static UserService INSTANCE;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    private UserService() {
    }

    public UserDao getUserDao() {
        return UserDao.getInstance();
    }
}

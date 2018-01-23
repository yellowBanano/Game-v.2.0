import dao.UserDao;
import entities.User;

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
        return UserDao.getInstance().getUser();
    }
}

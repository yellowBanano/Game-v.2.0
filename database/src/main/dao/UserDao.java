package dao;

import entities.User;

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

        private UserDao() {}

        public User getUser() {
            return new User("someEmail", "Newbie", "1111");
        }
}

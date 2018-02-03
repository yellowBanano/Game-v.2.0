package dao;

import entities.Type;
import support_entities.SessionGetter;

public class TypeDao {
    private static TypeDao INSTANCE;

    public static TypeDao getInstance() {
        if (INSTANCE == null) {
            synchronized (TypeDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TypeDao();
                }
            }
        }
        return INSTANCE;
    }

    private TypeDao() {
    }

    public Type getType(Long id) {
        return (Type) SessionGetter.getData(Type.class, id);
    }
}

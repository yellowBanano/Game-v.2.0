package by.myself.dao;

import by.myself.entities.Type;

public class TypeDao extends BaseDao<Type> {

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

    @Override
    protected Class<Type> getEntityClass() {
        return Type.class;
    }
}

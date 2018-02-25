package by.myself.dao;

import by.myself.entities.Material;

public class MaterialDao extends BaseDao<Material> {

    private static MaterialDao INSTANCE;

    public static MaterialDao getInstance() {
        if (INSTANCE == null) {
            synchronized (MaterialDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MaterialDao();
                }
            }
        }
        return INSTANCE;
    }

    private MaterialDao() {

    }

    @Override
    protected Class<Material> getEntityClass() {
        return Material.class;
    }
}

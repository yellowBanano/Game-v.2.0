package dao;

import entities.Material;
import support_entities.SessionGetter;

public class MaterialDao {
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

    public Material getMaterial(Long id) {
        return (Material) SessionGetter.getData(Material.class, id);
    }
}

package by.myself.dao;

import by.myself.entities.Material;
import by.myself.entities.QMaterial;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

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
    public List<Material> findAll(Session session) {
        JPAQuery<Material> query = new JPAQuery<>(session);
        QMaterial material = QMaterial.material;
        query.select(material)
                .from(material);
        return query.fetchResults().getResults();
    }

    @Override
    public Material findById(Session session, Long id) {
        JPAQuery<Material> query = new JPAQuery<>(session);
        QMaterial material = QMaterial.material;
        query.select(material)
                .from(material)
                .where(material.id.eq(id));
        return query.fetchOne();
    }
}

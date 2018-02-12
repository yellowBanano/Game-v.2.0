package by.myself.dao;

import by.myself.entities.QType;
import by.myself.entities.Type;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

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
    public List<Type> findAll(Session session) {
        JPAQuery<Type> query = new JPAQuery<>(session);
        QType type = QType.type;
        query.select(type)
                .from(type);
        return query.fetchResults().getResults();
    }

    @Override
    public Type findById(Session session, Long id) {
        JPAQuery<Type> query = new JPAQuery<>();
        QType type = QType.type;
        query.select(type)
                .from(type)
                .where(type.id.eq(id));
        return query.fetchOne();
    }
}

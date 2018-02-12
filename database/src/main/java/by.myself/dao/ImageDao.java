package by.myself.dao;

import by.myself.entities.Image;
import by.myself.entities.QImage;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

public class ImageDao extends BaseDao<Image> {

    private static ImageDao INSTANCE;

    public static ImageDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ImageDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageDao();
                }
            }
        }
        return INSTANCE;
    }

    private ImageDao() {
    }

    @Override
    public List<Image> findAll(Session session) {
        JPAQuery<Image> query = new JPAQuery<>(session);
        QImage image = QImage.image;
        query.select(image)
                .from(image);
        return query.fetchResults().getResults();
    }

    @Override
    public Image findById(Session session, Long id) {
        JPAQuery<Image> query = new JPAQuery<>(session);
        QImage image = QImage.image;
        query.select(image)
                .from(image)
                .where(image.id.eq(id));
        return query.fetchOne();
    }
}

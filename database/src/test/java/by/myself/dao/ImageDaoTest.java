package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Image;
import org.hibernate.Session;
import org.junit.Test;

public class ImageDaoTest extends BaseTest {

    @Test
    public void saveImagee() {
        Session session = SESSION_FACTORY.openSession();

        Image image = new Image("link");
        ImageDao.getInstance().save(session, image);

        session.close();
    }

    @Test
    public void findByIdImage() {
        Session session = SESSION_FACTORY.openSession();

        ImageDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllImages() {
        Session session = SESSION_FACTORY.openSession();

        ImageDao.getInstance().findAll(session);

        session.close();
    }
}

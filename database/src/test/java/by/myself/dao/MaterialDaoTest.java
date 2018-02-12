package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Material;
import org.hibernate.Session;
import org.junit.Test;

public class MaterialDaoTest extends BaseTest {

    @Test
    public void saveMaterial() {
        Session session = SESSION_FACTORY.openSession();

        Material material = new Material("name");
        MaterialDao.getInstance().save(session, material);

        session.close();
    }

    @Test
    public void findByIdMaterial() {
        Session session = SESSION_FACTORY.openSession();

        MaterialDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllMaterials() {
        Session session = SESSION_FACTORY.openSession();

        MaterialDao.getInstance().findAll(session);

        session.close();
    }
}

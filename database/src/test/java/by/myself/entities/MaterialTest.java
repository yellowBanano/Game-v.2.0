package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class MaterialTest extends BaseTest {

    @Test
    public void testSaveMaterialToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Material material = new Material("name");
        session.save(material);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetMaterialFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Material.class, 1L));

        transaction.commit();
        session.close();
    }
}

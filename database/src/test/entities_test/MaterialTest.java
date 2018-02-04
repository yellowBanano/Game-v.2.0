package entities_test;

import entities.Material;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

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
        System.out.println(SessionGetter.getData(Material.class, 1L));
    }
}

package maken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import maken.entity.Klant;

import java.io.File;

public class DeleteKlant {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Klant.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            int klantId = 2;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting klant with id: "+ klantId);
            Klant myklant = session.get(Klant.class, klantId);

            System.out.println("Deleting klant:"+ myklant);

            System.out.println("Deleting klant id=3");
            session.createQuery("delete from klant where id=3").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Klaar");
        }finally {
            factory.close();
        }

    }
}

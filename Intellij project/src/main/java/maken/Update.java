package maken;

import maken.entity.Klant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Update {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Klant.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            int klantId =4;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting klant with id: "+ klantId);
            Klant myklant = session.get(Klant.class, klantId);

            /*
            Update klante
             */
            myklant.setFirstName("2Nakzo");
            myklant.setLastName("Ren");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            /*
            Alle emails updaten
             */
            session.createQuery("update klant s set s.email='ozkan@gmail.com'").executeUpdate();


            session.getTransaction().commit();




        }finally {
            factory.close();
        }
    }
}

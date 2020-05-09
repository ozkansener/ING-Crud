package maken;

import maken.entity.Klant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class QueryKlant {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Klant.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

            Klant klant = new Klant("Ozkan", "Sener", "ozkansener@gmail.com");
            Klant klant2 = new Klant("2Ozkan", "2Sener", "2ozkansener@gmail.com");


            session.beginTransaction();


            session.save(klant);
            session.save(klant2);


            session.getTransaction().commit();

        } finally {
            factory.close();

        }
    }
}

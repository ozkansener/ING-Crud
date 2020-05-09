package maken;

import maken.entity.Klant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class PrimaireSleutel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Klant.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            /*
            Creeren klant object
             */

            Klant klant1 = new Klant("Adyes", "Herseyim", "adyes.herseyim@ozkan.com");
            Klant klant2 = new Klant("Patrick", "Dammen", "patrick-dammen@hotmail.com");
            Klant klant3 = new Klant("Eric", "Broek", "e.broek@ing.nl");

            /*
            Op basis van factory de class wordt bepaald: begin transatie die bij sessie hoort.

             */
            session.beginTransaction();


            /*
            Saven klant
             */
            session.save(klant1);
            session.save(klant2);
            session.save(klant3);

            /*
            flush check and disconnect
             */
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}

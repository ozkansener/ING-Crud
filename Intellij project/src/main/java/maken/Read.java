package maken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import maken.entity.Klant;

import java.io.File;

public class Read {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Klant.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new klant object...");
            Klant tempklant = new Klant("ING", "Bank", "ing@ing.nl");
            session.beginTransaction();

            System.out.println("Saving klant:");
            System.out.println(tempklant);
            session.save(tempklant);
            session.getTransaction().commit();

            System.out.println("Saved klant Genereated ID: "+tempklant.getId());

            session=factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting stuent with id: "+ tempklant.getId());
            Klant myklant = session.get(Klant.class, tempklant.getId());

            System.out.println("Get complete: "+ myklant);
            session.getTransaction().commit();

            System.out.println("Klaar");


        } finally {
            factory.close();
        }
    }
}

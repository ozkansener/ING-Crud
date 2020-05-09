import java.sql.Connection;
import java.sql.DriverManager;
/*
Testen of ik met DB kan connecten
 */


public class TestJdbc {

    public static void main (String[] args){


        String jdbcUrl = "jdbc:mysql://localhost/TEST?serverTimezone=UTC";
        String user = "root";
        String pass = "password";

        try {
            System.out.println("Proberen");
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Gelukt");
        } catch (Exception exc) {
            exc.printStackTrace();

    }
}
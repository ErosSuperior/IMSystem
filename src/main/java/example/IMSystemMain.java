package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IMSystemMain {
//    public static void main(String[] args) {
//        // Build SessionFactory
//        Configuration config = new Configuration().configure("hibernate.cfg.xml");
//        config.addAnnotatedClass(Role.class); // add entities
//        SessionFactory factory = config.buildSessionFactory();
//
//        // Open session
//        Session session = factory.openSession();
//
//        // Test open & transaction
//        session.beginTransaction();
//        System.out.println("Hibernate connected successfully!");
//        session.getTransaction().commit();
//
//        // Close session
//        session.close();
//        factory.close();
//    }

    public static void main(String[] args) {
        SpringApplication.run(IMSystemMain.class, args);
    }
}

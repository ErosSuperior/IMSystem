package example;

import example.entities.User;
import example.repository.UserRepo;
import example.service.impl.Userimpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import example.entities.Role;

import java.util.Optional;

@SpringBootApplication
public class IMSystemMain {
    public static void main(String[] args) {
        SpringApplication.run(IMSystemMain.class, args);
    }

    // Hàm này dùng để test kết nối Hibernate thủ công
    public static void testHibernateConnection() {
        // Build SessionFactory
       Configuration config = new Configuration().configure("hibernate.cfg.xml");
       config.addAnnotatedClass(Role.class); // add entities
       SessionFactory factory = config.buildSessionFactory();

       // Open session
       Session session = factory.openSession();

       // Test open & transaction
       session.beginTransaction();
       System.out.println("Hibernate connected successfully!");
       session.getTransaction().commit();
       Userimpl userimpl = new Userimpl();
       System.out.println(userimpl.login("user0","password0"));
//        Close session
        session.close();
        factory.close();
   }
}

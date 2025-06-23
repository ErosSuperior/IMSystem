package example;

import example.entities.User;
import example.repository.UserRepository;
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
//        Userimpl userimpl = new Userimpl();
//        System.out.println(userimpl.login("user0","password0"));
//        // Close session
////        session.close();
////        factory.close();
//    }
//}
        // Giả lập UserRepository
        UserRepository mockRepo = new UserRepository() {
            @Override
            public Optional<User> findByUsername(String username) {
                // Giả lập dữ liệu user trong DB
                if (username.equals("user0")) {
                    User user = new User();
                    user.setUsername("user0");
                    user.setPassword_hash("123456"); // Mật khẩu đúng
                    return Optional.of(user);
                }
                return Optional.empty();
            }

            // Nếu UserRepository có các method khác thì cần override tiếp
        };

        // Gán repository giả lập vào service
        Userimpl userService = new Userimpl();
        userService.setRepo(mockRepo); // phải viết thêm setter

        // Test case: đúng username + password
        User u1 = userService.login("user0", "123456");
        System.out.println("Test đúng: " + (u1 != null ? "✅ Thành công" : "❌ Thất bại"));

        // Test case: sai password
        User u2 = userService.login("user0", "wrongpass");
        System.out.println("Test sai mật khẩu: " + (u2 != null ? "❌ Sai" : "✅ Đúng"));

        // Test case: sai username
        User u3 = userService.login("notExist", "123456");
        System.out.println("Test sai username: " + (u3 != null ? "❌ Sai" : "✅ Đúng"));
    }
}

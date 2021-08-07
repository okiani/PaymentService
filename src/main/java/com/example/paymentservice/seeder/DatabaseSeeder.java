package com.example.paymentservice.seeder;

import com.example.paymentservice.entity.User;
import com.example.paymentservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DatabaseSeeder {

//    private Logger logger = Logger.getLogger(DatabaseSeeder.class);
    private IUserRepository userRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(
            IUserRepository userRepository,
            JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    private void seedUsersTable() {

        String sql = "SELECT * FROM users";
        List<User> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);

        if(u == null || u.size() <= 0) {

            //user1
            User user = new User();
            user.setUsername("omidkiani");
            user.setEmail("k@k.com");
            user.setPassword(new BCryptPasswordEncoder().encode("test123456"));
            user.setStatus(true);
            user.setConfirmEmail(true);
            user.setAddress("iran,tehran");
            user.setMobile("09331116877");
            user.setPhoneNumber("02177483297");
            userRepository.save(user);

            //user 2
            User user2 = new User();
            user2.setUsername("ali hosseini");
            user2.setEmail("a@a.com");
            user2.setPassword(new BCryptPasswordEncoder().encode("test123456"));
            user2.setStatus(true);
            user2.setConfirmEmail(true);
            user2.setAddress("iran,tehran");
            user2.setMobile("09124788391");
            user2.setPhoneNumber("02199894673");
            userRepository.save(user2);

            System.out.println("success");
        } else {
            System.out.println("Users Seeding Not Required");
//            logger.trace("Users Seeding Not Required");
        }
    }

}

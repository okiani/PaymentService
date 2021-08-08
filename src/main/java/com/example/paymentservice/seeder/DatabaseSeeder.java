package com.example.paymentservice.seeder;

import com.example.paymentservice.entity.Currency;
import com.example.paymentservice.entity.User;
import com.example.paymentservice.repository.ICurrencyRepository;
import com.example.paymentservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DatabaseSeeder {

    //    private Logger logger = Logger.getLogger(DatabaseSeeder.class);
    private IUserRepository userRepository;
    private ICurrencyRepository currencyRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(
            IUserRepository userRepository,
            ICurrencyRepository currencyRepository,
            JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.currencyRepository = currencyRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
        seedCurrencyTable();
    }

    //user seeder
    private void seedUsersTable() {

        String sqlUser = "SELECT * FROM users";
        List<User> userObj = jdbcTemplate.query(sqlUser, (resultSet, rowNum) -> null);

        if (userObj == null || userObj.size() <= 0) {

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
            user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
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
            user2.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            user2.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            userRepository.save(user2);

            System.out.println("created user successfully.");
        }
    }

    //currency seeder
    private void seedCurrencyTable() {

        String sqlCurrency = "SELECT * FROM currencies";
        List<User> currencyObj = jdbcTemplate.query(sqlCurrency, (resultSet, rowNum) -> null);

        if (currencyObj == null || currencyObj.size() <= 0) {

            //currency
            Currency currency = new Currency();
            currency.setName("ریال");
            currency.setDescriptor("rial");
            currency.setSign("﷼");
            currency.setStatus(true);
            currency.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            currency.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            currencyRepository.save(currency);

            System.out.println("created currency successfully.");
        }
    }

}

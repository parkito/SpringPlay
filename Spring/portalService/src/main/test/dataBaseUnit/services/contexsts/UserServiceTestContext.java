package dataBaseUnit.services.contexsts;

import com.portal.services.api.UserService;
import com.portal.services.implementation.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Artem Karnov @date 09.12.2016.
 *         artem.karnov@t-systems.com
 **/
@Configuration
@EnableTransactionManagement
public class UserServiceTestContext {
    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

}
package by.myself.service;

import by.myself.config.PersistenceConfig;
import by.myself.config.ServiceConfig;
import by.myself.exception.AccountExistsException;
import by.myself.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class,  ServiceConfig.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    private static final UserModel USER_MODEL = new UserModel();
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    static {
        USER_MODEL.setEmail("someEmail@sad.du");
        USER_MODEL.setUsername("someUsername");
        USER_MODEL.setFirstName("First Name");
        USER_MODEL.setLastName("Last Name");
        USER_MODEL.setPassword(encoder.encode("admin"));
    }

    @Test
    public void userRegistration() {
        try {
            userService.registerNewUserAccount(USER_MODEL);
            userService.registerUserWithRoleId(USER_MODEL, 1L);
        } catch (AccountExistsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loaderTest() {
        System.out.println(userService.loadUserByUsername(USER_MODEL.getUsername()));
        UserModel next = userService.getAllUsers().iterator().next();
        userService.updateUserWithRoleId(USER_MODEL, 2L);
    }
}

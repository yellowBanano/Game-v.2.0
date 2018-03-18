package by.myself.service;

import by.myself.entities.User;
import by.myself.exception.AccountExistsException;
import by.myself.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User registerNewUserAccount(UserModel userModel) throws AccountExistsException;

    UserDetails loadUserByUsername(String username);
}

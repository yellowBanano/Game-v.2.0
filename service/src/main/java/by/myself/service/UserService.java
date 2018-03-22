package by.myself.service;

import by.myself.entities.User;
import by.myself.exception.AccountExistsException;
import by.myself.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User registerNewUserAccount(UserModel userModel) throws AccountExistsException;

    User registerUserWithRoleId(UserModel userModel, Long roleId);

    UserDetails loadUserByUsername(String username);

    List<UserModel> getAllUsers();

    void updateUserWithRoleId(UserModel userModel, long roleId);
}

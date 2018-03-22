package by.myself.service;

import by.myself.annotation.Loggable;
import by.myself.entities.Role;
import by.myself.entities.User;
import by.myself.entities.Wallet;
import by.myself.exception.AccountExistsException;
import by.myself.model.RoleEnum;
import by.myself.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@Loggable
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final WalletRepository walletRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, WalletRepository walletRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.walletRepository = walletRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User registerNewUserAccount(UserModel userModel) throws AccountExistsException {
        if (emailExist(userModel.getEmail(), userModel.getUsername())) {
            throw new AccountExistsException(
                    "There is an account with that email address: " + userModel.getEmail());
        }
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());

        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        Role userRole = roleRepository.findByName(RoleEnum.USER.toString());
        user.setRole(userRole);

        Wallet userWallet = new Wallet();
        user.setWallet(userWallet);
        walletRepository.save(userWallet);

        return userRepository.save(user);
    }

    @Override
    public User registerUserWithRoleId(UserModel userModel, Long roleId) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        Role role = roleRepository.findById(roleId).get();
        user.setRole(role);

        Wallet userWallet = new Wallet();
        user.setWallet(userWallet);
        walletRepository.save(userWallet);

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exist!");
        }
        HashSet<Role> roles = new HashSet<>();
        roles.add(user.getRole());
        return new org.springframework.security.core.userdetails
                .User(username, user.getPassword(), generateAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> generateAuthorities(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    private List<UserModel> convertEntityToModel(List<User> users) {
        List<UserModel> convertedUsers = new ArrayList<>();
        if (users != null && !users.isEmpty()) {
            users.forEach(user -> {
                UserModel userModel = new UserModel(
                        user.getId(),
                        user.getEmail(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getRole());
                convertedUsers.add(userModel);
            });
        }
        return convertedUsers;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return convertEntityToModel(userRepository.findAll());
    }

    @Override
    public void updateUserWithRoleId(UserModel userModel, long roleId) {
        Role role = roleRepository.findById(roleId).get();
        User user = userRepository.findByUsername(userModel.getUsername());
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    private boolean emailExist(String email, String username) {
        return userRepository.findFirstByEmailOrUsername(email, username) != null;
    }
}

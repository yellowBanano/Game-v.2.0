package by.myself.controller;

import by.myself.entities.Role;
import by.myself.entities.User;
import by.myself.model.UserModel;
import by.myself.service.RoleRepository;
import by.myself.service.UserRepository;
import by.myself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository, UserRepository userRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("users")
    public List<UserModel> allUsers() {
        return userService.getAllUsers();
    }

    @ModelAttribute("user")
    public UserModel user() {
        return new UserModel();
    }

    @ModelAttribute("roles")
    public List<Role> allRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @GetMapping("/admin/users")
    public String getUsers() {
        return "admin/users";
    }

    @PostMapping("/admin/users")
    public String createUser(UserModel user, long roleId) {
        userService.registerUserWithRoleId(user, roleId);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/update/{id}")
    public String goToUpdatePage(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "update/user";
    }

    @PostMapping("/admin/users/update")
    public String updateUser(UserModel user, long roleId) {
        userService.updateUserWithRoleId(user, roleId);
        return "redirect:/admin/users";
    }
}

package by.myself.controller;

import by.myself.model.UserModel;
import by.myself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String redirectAfterLogin() {
        return "registration";
    }

    @PostMapping("/login")
    public String checkLoginInfo(UserModel userModel) {
        try {
            UserDetails user = userService.loadUserByUsername(userModel.getUsername());
            if (!encoder.matches(userModel.getPassword(), user.getPassword())) {
//                errors.add("wrong password");
                return "redirect:/registration";
            }
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return "redirect:/registration";
//            errors.add("username not found");
        }
        return "redirect:/search";
    }
}

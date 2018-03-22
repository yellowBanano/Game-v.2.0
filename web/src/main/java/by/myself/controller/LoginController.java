package by.myself.controller;

import by.myself.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @ModelAttribute
    public UserModel user() {
        return new UserModel();
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "registration";
    }
}

package by.myself.controller;

import by.myself.exception.AccountExistsException;
import by.myself.model.UserModel;
import by.myself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    @ModelAttribute
    public UserModel user() {
        return new UserModel();
    }

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @PostMapping("/registration")
    public String registration(UserModel user) {
        try {
            userService.registerNewUserAccount(user);
        } catch (AccountExistsException e) {
            e.printStackTrace();
        }
        return "registration";
    }
}

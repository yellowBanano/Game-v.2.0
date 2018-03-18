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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(@RequestParam("page") Optional<String> language) {
        return "registration";
    }

    @ModelAttribute("userModel")
    public UserModel userModel() {
        return new UserModel();
    }

    @PostMapping("/registration")
    public String workWithUserData(@Valid UserModel userModel, Errors errors) {
        try {
            userService.registerNewUserAccount(userModel);
        } catch (AccountExistsException e) {
            e.printStackTrace();
//            errors.add("accountExists");
        }
        return "registration";
    }
}

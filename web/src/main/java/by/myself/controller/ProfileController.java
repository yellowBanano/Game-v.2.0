package by.myself.controller;

import by.myself.entities.User;
import by.myself.model.RoleEnum;
import by.myself.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class ProfileController {

    private final UserRepository userRepository;

    @Autowired
    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute
    public User user(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName());
    }

    @GetMapping("/profile")
    public String goToPersonalAccount(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals(RoleEnum.ADMIN.toString()))) {
            return "redirect:/admin/users";
        }

        return "profile";
    }

    @GetMapping("/update/profile")
    public String updateProfile() {
        return "update/profile";
    }

    @PostMapping("/update/profile/finish")
    public String finishUpdating(User user) {
        userRepository.save(user);
        return "profile";
    }
}

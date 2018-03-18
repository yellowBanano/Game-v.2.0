package by.myself.model;

import by.myself.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Email
    private String email;

    @NotEmpty
    private String username;

    @Range(min = 5, max = 15)
    private String password;

    @Range(min = 5, max = 15)
    private String matchingPassword;

    private String firstName;
    private String lastName;
    private Set<Role> roles = new HashSet<>();
}

package by.myself.model;

import by.myself.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    private Long id;

    @Email
    private String email;

    @NotEmpty
    private String username;

    @Range(min = 5, max = 15)
    private String password;

    private String firstName;
    private String lastName;
    private Role role;
}

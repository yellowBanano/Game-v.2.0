package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_wallet", nullable = false, unique = true)
    private Wallet wallet;

    @Embedded
    private Location location;

    @ManyToMany(mappedBy = "usersOrdered")
    private Set<Product> orderedProducts = new HashSet<>();

    @OneToMany(mappedBy = "owner")
    private HashSet<CreditCard> cards;

    @Transient
    private String fullName = firstName + " " + lastName;

    public User(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
    }
}

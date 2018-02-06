package by.myself.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "id_wallet", nullable = false, unique = true)
    private Wallet wallet;

    @Embedded
    private Location location;

    @OneToMany(mappedBy = "consumer")
    private Set<Order> orders = new HashSet<>();

    @Transient
    private String fullName = firstName + " " + lastName;

    public User(String email, String login, String password, Wallet wallet) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", orders=" + orders +
                ", fullName='" + fullName + '\'' +
                ", id_wallet='" + wallet.getId() + '\'' +
                '}';
    }
}

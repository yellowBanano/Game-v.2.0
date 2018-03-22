package by.myself.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"orders", "wallet"})
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "my-cache")
public class User extends BaseEntity {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade={javax.persistence.CascadeType.REMOVE}, orphanRemoval=true)
    @JoinColumn(name = "id_wallet", nullable = false, unique = true)
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @Embedded
    private Location location;

    @OneToMany(cascade={javax.persistence.CascadeType.REMOVE}, orphanRemoval=true, mappedBy = "consumer")
    @Cascade(CascadeType.DELETE)
    private Set<Order> orders = new HashSet<>();
}

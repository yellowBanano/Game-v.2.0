package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wallet extends BaseEntity {

    @OneToOne(mappedBy = "wallet")
    private User user;

    @Column(name = "amount")
    private Double amount;

    @OneToMany(mappedBy = "wallet")
    private Set<Payment> payments;
}

package by.myself.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"payments"})
public class Wallet extends BaseEntity {

    @OneToOne(mappedBy = "wallet")
    private User user;

    @Column(name = "amount", columnDefinition = "BIGINT")
    private Double amount;

    @OneToMany(mappedBy = "wallet")
    private Set<Payment> payments;
}

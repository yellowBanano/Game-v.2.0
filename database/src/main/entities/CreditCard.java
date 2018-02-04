package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "credit_cards")
@PrimaryKeyJoinColumn(name = "id_payment")
public class CreditCard extends Payment {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User owner;

    public CreditCard(LocalDateTime time, Wallet wallet, String serialNumber, String cvv, LocalDate expireDate, User owner) {
        super(time, wallet);
        this.serialNumber = serialNumber;
        this.cvv = cvv;
        this.expireDate = expireDate;
        this.owner = owner;
    }
}

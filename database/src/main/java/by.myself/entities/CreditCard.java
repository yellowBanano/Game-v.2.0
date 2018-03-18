package by.myself.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
@ToString
@PrimaryKeyJoinColumn(name = "id_payment")
public class CreditCard extends Payment {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;
}

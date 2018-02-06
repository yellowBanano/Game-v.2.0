package by.myself.entities;

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
@Table(name = "credit_cards")
@PrimaryKeyJoinColumn(name = "id_payment")
public class CreditCard extends Payment {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    public CreditCard(LocalDateTime time, Wallet wallet, String serialNumber, String cvv, LocalDate expireDate) {
        super(time, wallet);
        this.serialNumber = serialNumber;
        this.cvv = cvv;
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "time=" + super.getTime() +
                ", wallet=" + super.getWallet().getId() +
                '}' +
                " CreditCard{" +
                "serialNumber='" + serialNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}

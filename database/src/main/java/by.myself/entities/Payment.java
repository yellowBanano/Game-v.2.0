package by.myself.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment extends BaseEntity {

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;

    @Override
    public String toString() {
        return "Payment{" +
                "time=" + time +
                ", wallet=" + wallet.getId() +
                '}';
    }
}

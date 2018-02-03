package entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order extends BaseEntity {

    @Column(name = "datetime_order", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @Column(name = "delivered", nullable = false)
    private boolean delivered;
}

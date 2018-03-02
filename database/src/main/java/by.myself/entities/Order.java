package by.myself.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_consumer")
    private User consumer;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "datetime_order", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @Column(name = "delivered", nullable = false)
    private boolean delivered;
}

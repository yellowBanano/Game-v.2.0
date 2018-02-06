package by.myself.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discount extends BaseEntity {

    @OneToMany(mappedBy = "discount")
    private Set<Product> products;

    @Column(name = "discount", nullable = false)
    private Double discount;

    public Discount(Double discount) {
        this.discount = discount;
    }
}

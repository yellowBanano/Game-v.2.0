package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discount extends BaseEntity {

    @OneToMany(mappedBy = "discount")
    private HashSet<Product> products;

    @Column(name = "discount", nullable = false)
    private Double discount;

    public Discount(Double discount) {
        this.discount = discount;
    }
}

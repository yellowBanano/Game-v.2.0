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
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Discount extends BaseEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "discount")
    private Set<Product> products;

    @Column(name = "discount", nullable = false, columnDefinition = "DECIMAL")
    private Double discount;
}

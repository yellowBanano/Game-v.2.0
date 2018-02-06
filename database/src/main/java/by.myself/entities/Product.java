package by.myself.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "producer")
    private String producer;

    @Column(name = "provider")
    private String provider;

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "amount")
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "id_image")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "id_discount")
    private Discount discount;

    @ManyToMany
    @JoinTable(
            name = "product_type",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_type")
    )
    private Set<Type> types = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "product_material",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_material")
    )
    private Set<Material> materials = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<Order> orders = new HashSet<>();

    public Product(String name, Double cost, Integer size, Integer amount, Image image) {
        this.name = name;
        this.cost = cost;
        this.size = size;
        this.amount = amount;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", producer='" + producer + '\'' +
                ", provider='" + provider + '\'' +
                ", size=" + size +
                ", amount=" + amount +
                ", id_image=" + image.getId() +
                '}';
    }
}

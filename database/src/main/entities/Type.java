package entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Type extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "types")
    private Set<Product> products = new HashSet<>();
}

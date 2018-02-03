package entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Image extends BaseEntity {

    @Column(name = "link")
    private String link;

    @OneToOne(mappedBy = "image")
    private Product product;

    public Image(String link) {
        this.link = link;
    }
}

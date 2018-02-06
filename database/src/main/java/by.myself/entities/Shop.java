package by.myself.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shop extends BaseEntity {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Location location;
}

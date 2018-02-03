package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Location {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;
}

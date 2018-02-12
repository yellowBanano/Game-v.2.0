package by.myself.dto;

import by.myself.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ProductDto {

    private String name;
    private Double cost;
    private String producer;
    private String provider;
    private Integer size;
    private Integer amount;
    private String image;
    private Double discount;

    public void convertToDto(Product product) {
        name = product.getName();
        cost = product.getCost();
        producer = product.getProducer();
        provider = product.getProvider();
        size = product.getSize();
        amount = product.getAmount();
        image = product.getImage().getLink();
        discount = product.getDiscount().getDiscount();
    }
}

package by.myself.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {//TODO Add images and discounts

    private String name;
    private Double cost;
    private String producer;
}

package by.myself.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {//TODO Add images and discounts

    @NotEmpty
    private String name;
    @NotNull
    private Double cost;

    private String producer;
}

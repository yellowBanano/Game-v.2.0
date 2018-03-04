package by.myself.service;

import by.myself.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductModel> searchProducts(String query, Double cost);
}

package by.myself.service;

import by.myself.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> searchProducts(String query, Double cost, Integer limit);
}

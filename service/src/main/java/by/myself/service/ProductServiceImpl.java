package by.myself.service;

import by.myself.entities.Product;
import by.myself.model.ProductModel;
import by.myself.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> searchProducts(String query, Double cost) {
        List<Product> foundProducts;
        if (cost == 0d) {
            foundProducts = productRepository.findAllByNameOrProducerOrCost(query, query, null);
        } else if (query.matches(" +")) {
            foundProducts = productRepository.findAllByNameOrProducerOrCost(null, null, cost);
        } else {
            foundProducts = productRepository.findAllByNameOrProducerOrCost(query, query, cost);
        }
        return convertEntityToModel(foundProducts);
    }

    private List<ProductModel> convertEntityToModel(List<Product> products) {
        List<ProductModel> convertedProducts = new ArrayList<>();
        if (products != null && !products.isEmpty()) {
            products.forEach(product -> convertedProducts.add(new ProductModel(product.getName(), product.getCost(), product.getProducer())));
        }
        return convertedProducts;
    }
}

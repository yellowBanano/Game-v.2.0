package by.myself.service;

import by.myself.annotation.Loggable;
import by.myself.entities.Product;
import by.myself.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Loggable
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> searchProducts(String query, Double cost, Integer limit) {
        List<Product> foundProducts;
        if (limit == 0) {
            foundProducts = productRepository.findAllByNameOrProducerOrCostOrderByName(query, query, cost);
        } else if (limit == 25) {
            foundProducts = productRepository.findTop25ByNameOrProducerOrCostOrderByName(query, query, cost);
        } else if (limit == 50) {
            foundProducts = productRepository.findTop50ByNameOrProducerOrCostOrderByName(query, query, cost);
        } else {
            foundProducts = productRepository.findTop100ByNameOrProducerOrCostOrderByName(query, query, cost);
        }
        return convertEntityToModel(foundProducts);
    }

    private List<ProductModel> convertEntityToModel(List<Product> products) {
        List<ProductModel> convertedProducts = new ArrayList<>();
        if (products != null && !products.isEmpty()) {
            products.forEach(product -> {
                ProductModel productModel = new ProductModel(product.getName(), product.getCost(), product.getProducer());
                convertedProducts.add(productModel);
            });
        }
        return convertedProducts;
    }
}

package by.myself.service;

import by.myself.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findAllByNameOrProducerOrCostOrderByName(String name, String producer, Double cost);

    List<Product> findTop25ByNameOrProducerOrCostOrderByName(String name, String producer, Double cost);

    List<Product> findTop50ByNameOrProducerOrCostOrderByName(String name, String producer, Double cost);

    List<Product> findTop100ByNameOrProducerOrCostOrderByName(String name, String producer, Double cost);
}

package by.myself.repository;

import by.myself.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findAllByNameOrProducerOrCost(String name, String producer, Double cost);//TODO Attach sorting
}

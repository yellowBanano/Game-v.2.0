package by.myself.repository;

import by.myself.entities.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}

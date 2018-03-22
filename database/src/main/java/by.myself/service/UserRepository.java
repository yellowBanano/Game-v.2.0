package by.myself.service;

import by.myself.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findFirstByEmailOrUsername(String email, String username);

    List<User> findAll();
}

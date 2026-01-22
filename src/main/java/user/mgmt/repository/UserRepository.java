package user.mgmt.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import user.mgmt.entities.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUsername(String username, Pageable pageable);
    List<User> findByUsername(String username, Sort sort);
}

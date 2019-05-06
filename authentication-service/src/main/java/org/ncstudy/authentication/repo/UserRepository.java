package org.ncstudy.authentication.repo;

import org.ncstudy.authentication.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    void deleteUserByUsername(String username);

}
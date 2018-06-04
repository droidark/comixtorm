package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

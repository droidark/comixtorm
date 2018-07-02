package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndTitlesIn(String username, Set<Title> titles);
}

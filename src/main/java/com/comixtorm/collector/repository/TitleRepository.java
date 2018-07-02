package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Issue;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TitleRepository extends CrudRepository<Title, Long> {
    Title findByVanity(String vanity);
    Title findByVanityOrderByIdAsc(String vanity);
    Title findByVanityAndUsersIn(String vanity, Set<User> users);
}

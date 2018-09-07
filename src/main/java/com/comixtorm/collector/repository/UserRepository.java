package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.model.UserPublisherTitleIssueCover;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndUserPublisherTitleIssueCoversIn(
            String username, Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers);
}

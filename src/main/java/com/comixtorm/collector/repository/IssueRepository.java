package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    Issue findByVanity(String vanity);
}

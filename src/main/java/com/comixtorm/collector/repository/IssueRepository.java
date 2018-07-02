package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Issue;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    Issue findByVanity(String vanity);
    Set<Issue> findByNameContainingIgnoreCase(String name);
    Set<Issue> findByEventContainingIgnoreCase(String event);
    Set<Issue> findByStoryArchContainingIgnoreCase(String storyArch);
    Set<Issue> findByIsbnContaining(Integer isbn);

}

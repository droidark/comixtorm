package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Issue;
import com.comixtorm.collector.model.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    Issue findByVanity(String vanity);
    Set<Issue> findByNameContainingIgnoreCaseOrderById(String name);
    Set<Issue> findByEventContainingIgnoreCase(String event);
    Set<Issue> findByStoryArchContainingIgnoreCase(String storyArch);
    Set<Issue> findByIsbnContaining(String isbn);
    Issue findByVanityAndTitle(String vanity, Title title);
}

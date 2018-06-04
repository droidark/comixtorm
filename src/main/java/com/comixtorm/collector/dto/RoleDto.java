package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto implements Comparable<RoleDto> {
    private Long id;
    private String description;
    private Set<IssueDto> issues;
    private Set<AuthorDto> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<IssueDto> getIssues() {
        return issues;
    }

    public void setIssues(Set<IssueDto> issues) {
        this.issues = issues;
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(RoleDto o) {
        return (int) (id - o.getId());
    }
}

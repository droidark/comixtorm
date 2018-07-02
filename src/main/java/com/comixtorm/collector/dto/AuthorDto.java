package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto implements Comparable<AuthorDto> {
    private Long id;
    private String name;
    private String avatar;
    private String biography;
    private Set<IssueDto> issues;
    private Set<RoleDto> roles;
    private Set<AuthorSocialNetworkDto> authorSocialNetworks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<IssueDto> getIssues() {
        return issues;
    }

    public void setIssues(Set<IssueDto> issues) {
        this.issues = issues;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public Set<AuthorSocialNetworkDto> getAuthorSocialNetworks() {
        return authorSocialNetworks;
    }

    public void setAuthorSocialNetworks(Set<AuthorSocialNetworkDto> authorSocialNetworks) {
        this.authorSocialNetworks = authorSocialNetworks;
    }

    @Override
    public int compareTo(AuthorDto o) {
        return (int) (id - o.getId());
    }
}

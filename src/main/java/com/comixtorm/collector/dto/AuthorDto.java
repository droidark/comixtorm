package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto implements Comparator<AuthorDto> {
    private Long id;
    private String name;
    private String avatar;
    private String biography;
    private List<IssueDto> issues;
    private List<RoleDto> roles;
    private List<AuthorSocialNetworkDto> authorSocialNetworks;

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

    public List<IssueDto> getIssues() {
        return issues;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<AuthorSocialNetworkDto> getAuthorSocialNetworks() {
        return authorSocialNetworks;
    }

    public void setAuthorSocialNetworks(List<AuthorSocialNetworkDto> authorSocialNetworks) {
        this.authorSocialNetworks = authorSocialNetworks;
    }

    public void setIssues(List<IssueDto> issues) {
        this.issues = issues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDto)) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(id, authorDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compare(AuthorDto o1, AuthorDto o2) {
        return  o1.getId() < o2.getId() ? -1 : o1.getId() == o2.getId() ? 0 : 1;
    }
}

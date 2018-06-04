package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "cxt_author")
public class Author {
    private Long id;
    private String name;
    private String avatar;
    private String biography;
    private Set<Role> roles = new TreeSet<>();
    private Set<AuthorSocialNetwork> authorSocialNetworks = new TreeSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "author_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "author_avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name = "author_biography")
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "author")
    public Set<AuthorSocialNetwork> getAuthorSocialNetworks() {
        return authorSocialNetworks;
    }

    public void setAuthorSocialNetworks(Set<AuthorSocialNetwork> authorSocialNetworks) {
        this.authorSocialNetworks = authorSocialNetworks;
    }
}

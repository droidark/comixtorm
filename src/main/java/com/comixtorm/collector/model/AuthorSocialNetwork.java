package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cxt_author_social_network")
public class AuthorSocialNetwork {
    private Long id;
    private String socialNetworkName;
    private String socialNetworkNickname;
    private String socialNetworkUrl;
    private Author author;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_social_network_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "social_network_name")
    public String getSocialNetworkName() {
        return socialNetworkName;
    }

    public void setSocialNetworkName(String socialNetworkName) {
        this.socialNetworkName = socialNetworkName;
    }

    @Column(name = "social_network_nickname")
    public String getSocialNetworkNickname() {
        return socialNetworkNickname;
    }

    public void setSocialNetworkNickname(String socialNetworkNickname) {
        this.socialNetworkNickname = socialNetworkNickname;
    }

    @Column(name = "social_network_url")
    public String getSocialNetworkUrl() {
        return socialNetworkUrl;
    }

    public void setSocialNetworkUrl(String socialNetworkUrl) {
        this.socialNetworkUrl = socialNetworkUrl;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authorSocialNetworks"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

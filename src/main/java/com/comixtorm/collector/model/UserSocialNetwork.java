package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cxt_user_social_network")
public class UserSocialNetwork {
    private Long id;
    private String socialNetworkName;
    private String socialNetworkNickname;
    private String socialNetworkUrl;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_social_network_id")
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "userSocialNetworks"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

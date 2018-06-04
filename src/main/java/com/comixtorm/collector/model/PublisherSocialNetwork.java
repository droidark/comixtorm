package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "cxt_publisher_social_network")
public class PublisherSocialNetwork {
    private Long id;
    private String socialNetworkName;
    private String socialNetworkNickname;
    private String socialNetworkUrl;
    private Publisher publisherSn;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "publisher_social_network_id")
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "publisherSocialNetworks"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    public Publisher getPublisherSn() {
        return publisherSn;
    }

    public void setPublisherSn(Publisher publisherSn) {
        this.publisherSn = publisherSn;
    }
}

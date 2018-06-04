package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "cxt_publisher")
public class Publisher {
    private Long id;
    private String name;
    private String vanity;
    private String url;
    private String logo;
    private String information;
    private Set<Title> titles = new TreeSet<>();
    private Set<PublisherSocialNetwork> publisherSocialNetworks = new TreeSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "publisher_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "publisher_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "publisher_vanity")
    public String getVanity() {
        return vanity;
    }

    public void setVanity(String vanity) {
        this.vanity = vanity;
    }

    @Column(name = "publisher_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "publisher_logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "publisher_information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher")
    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "publisherSn")
    public Set<PublisherSocialNetwork> getPublisherSocialNetworks() {
        return publisherSocialNetworks;
    }

    public void setPublisherSocialNetworks(Set<PublisherSocialNetwork> publisherSocialNetworks) {
        this.publisherSocialNetworks = publisherSocialNetworks;
    }
}

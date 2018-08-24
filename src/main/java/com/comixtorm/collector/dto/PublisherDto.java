package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherDto implements Comparable<PublisherDto> {
    private Long id;
    private String name;
    private String vanity;
    private String url;
    private String logo;
    private String information;
    private List<TitleDto> titles;
    private List<PublisherSocialNetworkDto> publisherSocialNetworks;

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

    public String getVanity() {
        return vanity;
    }

    public void setVanity(String vanity) {
        this.vanity = vanity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<TitleDto> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleDto> titles) {
        this.titles = titles;
    }

    public List<PublisherSocialNetworkDto> getPublisherSocialNetworks() {
        return publisherSocialNetworks;
    }

    public void setPublisherSocialNetworks(List<PublisherSocialNetworkDto> publisherSocialNetworks) {
        this.publisherSocialNetworks = publisherSocialNetworks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublisherDto)) return false;
        PublisherDto that = (PublisherDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public int compareTo(PublisherDto o) {
        return (int) (id - o.getId());
    }
}

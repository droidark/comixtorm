package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherDto implements Comparable<PublisherDto> {
    private Long id;
    private String name;
    private String vanity;
    private String url;
    private String logo;
    private String information;
    private Set<TitleDto> titles;

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

    public Set<TitleDto> getTitles() {
        return titles;
    }

    public void setTitles(Set<TitleDto> titles) {
        this.titles = titles;
    }

    @Override
    public int compareTo(PublisherDto o) {
        return (int) (id - o.getId());
    }
}

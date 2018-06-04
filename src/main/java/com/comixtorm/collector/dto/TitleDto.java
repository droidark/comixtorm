package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TitleDto implements Comparable<TitleDto> {
    private Long id;
    private String name;
    private String vanity;
    private String avatar;
    private Integer totalIssues;
    private Date launchDate;
    private PublisherDto publisher;
    private Set<IssueDto> issues;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getTotalIssues() {
        return totalIssues;
    }

    public void setTotalIssues(Integer totalIssues) {
        this.totalIssues = totalIssues;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto publisher) {
        this.publisher = publisher;
    }

    public Set<IssueDto> getIssues() {
        return issues;
    }

    public void setIssues(Set<IssueDto> issues) {
        this.issues = issues;
    }

    @Override
    public int compareTo(TitleDto o) {
        return (int) (id - o.getId());
    }
}

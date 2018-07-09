package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cxt_cover")
public class Cover implements Comparable<Cover> {
    private Long id;
    private String coverImageUrl;
    private Issue issue;
    private Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cover_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cover_img_url")
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "issue_id", nullable = false)
    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @OneToMany(mappedBy = "userPublisherTitleIssueCoverPK.cover", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<UserPublisherTitleIssueCover> getUserPublisherTitleIssueCovers() {
        return userPublisherTitleIssueCovers;
    }

    public void setUserPublisherTitleIssueCovers(Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers) {
        this.userPublisherTitleIssueCovers = userPublisherTitleIssueCovers;
    }

    @Override
    public int compareTo(Cover o) {
        return (int) (id - o.getId());
    }
}

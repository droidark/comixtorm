package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "cxt_title")
public class Title implements Comparable<Title> {
    private Long id;
    private String name;
    private String vanity;
    private String avatar;
    private Integer totalIssues;
    private Date launchDate;
    private Publisher publisher;
    private Set<Issue> issues = new TreeSet<>();
//    private Set<User> users = new TreeSet<>();
//    private Set<Issue> userIssues = new TreeSet<>();
    private Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "title_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "title_vanity")
    public String getVanity() {
        return vanity;
    }

    public void setVanity(String vanity) {
        this.vanity = vanity;
    }

    @Column(name = "title_avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name = "title_total_issues")
    public Integer getTotalIssues() {
        return totalIssues;
    }

    public void setTotalIssues(Integer totalIssues) {
        this.totalIssues = totalIssues;
    }

    @Column(name = "title_launch_date")
    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "titles"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @OneToMany(mappedBy = "title")
    @OrderBy("id")
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

//    @JsonBackReference
//    @ManyToMany(mappedBy = "titles")
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

//    @JsonManagedReference
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "cxt_user_x_title_issue_cover",
//            joinColumns = @JoinColumn(name = "title_id"),
//            inverseJoinColumns = @JoinColumn(name = "issue_id")
//    )
//    @OrderBy("id")
//    public Set<Issue> getUserIssues() {
//        return userIssues;
//    }
//
//    public void setUserIssues(Set<Issue> userIssues) {
//        this.userIssues = userIssues;
//    }

    @OneToMany(mappedBy = "userPublisherTitleIssueCoverPK.title", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<UserPublisherTitleIssueCover> getUserPublisherTitleIssueCovers() {
        return userPublisherTitleIssueCovers;
    }

    public void setUserPublisherTitleIssueCovers(Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers) {
        this.userPublisherTitleIssueCovers = userPublisherTitleIssueCovers;
    }

    @Override
    public int compareTo(Title o) {
        return (int) (id - o.getId());
    }
}

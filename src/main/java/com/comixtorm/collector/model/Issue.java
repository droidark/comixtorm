package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "cxt_issue")
public class Issue implements Comparable<Issue> {
    private Long id;
    private String name;
    private String vanity;
    private Integer number;
    private Float printPrice;
    private Float digitalPrice;
    private String currency;
    private Date publishedDate;
    private String shortReview;
    private String event;
    private String storyArch;
    private String isbn;
    private Title title;
    private Set<Cover> covers = new TreeSet<>();
//    private Set<Cover> userCovers = new TreeSet<>();
    private Set<Author> authors = new TreeSet<>();
    private Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "issue_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "issue_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "issue_vanity")
    public String getVanity() {
        return vanity;
    }

    public void setVanity(String vanity) {
        this.vanity = vanity;
    }

    @Column(name = "issue_number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "issue_print_price")
    public Float getPrintPrice() {
        return printPrice;
    }

    public void setPrintPrice(Float printPrice) {
        this.printPrice = printPrice;
    }

    @Column(name = "issue_digital_price")
    public Float getDigitalPrice() {
        return digitalPrice;
    }

    public void setDigitalPrice(Float digitalPrice) {
        this.digitalPrice = digitalPrice;
    }

    @Column(name = "issue_currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "issue_pubhished_date")
    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Column(name = "issue_short_review")
    public String getShortReview() {
        return shortReview;
    }

    public void setShortReview(String shortReview) {
        this.shortReview = shortReview;
    }

    @Column(name = "issue_event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Column(name = "issue_story_arch")
    public String getStoryArch() {
        return storyArch;
    }

    public void setStoryArch(String storyArch) {
        this.storyArch = storyArch;
    }

    @Column(name = "issue_isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id", nullable = false)
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "issue")
    public Set<Cover> getCovers() {
        return covers;
    }

    public void setCovers(Set<Cover> covers) {
        this.covers = covers;
    }

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "cxt_user_x_title_issue_cover",
//            joinColumns = @JoinColumn(name = "issue_id"),
//            inverseJoinColumns = @JoinColumn(name = "cover_id")
//    )
//    @OrderBy("id")
//    public Set<Cover> getUserCovers() {
//        return userCovers;
//    }
//
//    public void setUserCovers(Set<Cover> userCovers) {
//        this.userCovers = userCovers;
//    }

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "cxt_issue_x_author_role",
            joinColumns = @JoinColumn(name = "issue_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @OrderBy("id")
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @OneToMany(mappedBy = "userPublisherTitleIssueCoverPK.issue", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<UserPublisherTitleIssueCover> getUserPublisherTitleIssueCovers() {
        return userPublisherTitleIssueCovers;
    }

    public void setUserPublisherTitleIssueCovers(Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers) {
        this.userPublisherTitleIssueCovers = userPublisherTitleIssueCovers;
    }

    @Override
    public int compareTo(Issue o) {
        return (int) (id - o.getId());
    }
}

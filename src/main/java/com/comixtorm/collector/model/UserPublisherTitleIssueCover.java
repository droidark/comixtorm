package com.comixtorm.collector.model;

import javax.persistence.*;

@Entity
@Table(name = "cxt_user_publisher_title_issue_cover")
public class UserPublisherTitleIssueCover {
    private UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK = new UserPublisherTitleIssueCoverPK();
    private User user;
    private Publisher publisher;
    private Title title;
    private Issue issue;
    private Cover cover;

    @EmbeddedId
    public UserPublisherTitleIssueCoverPK getUserPublisherTitleIssueCoverPK() {
        return userPublisherTitleIssueCoverPK;
    }

    public void setUserPublisherTitleIssueCoverPK(UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK) {
        this.userPublisherTitleIssueCoverPK = userPublisherTitleIssueCoverPK;
    }

    @Transient
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Transient
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Transient
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Transient
    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Transient
    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }
}

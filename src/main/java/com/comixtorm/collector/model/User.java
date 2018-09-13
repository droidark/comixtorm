package com.comixtorm.collector.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "cxt_user")
public class User implements Comparable<User> {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String cover;
    private String aboutYou;
    private Date signUpDate;
    private String ipAddress;
    private String status;
    private Set<Profile> profiles = new TreeSet<>();
//    private Set<Title> titles = new TreeSet<>();
    private Set<UserSocialNetwork> userSocialNetworks = new TreeSet<>();
    private Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "user_avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name = "user_cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "user_about_you")
    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    @Column(name = "user_signup_date")
    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    @Column(name = "user_ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Column(name = "user_status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "cxt_user_x_profile",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

//    @JsonManagedReference
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "cxt_user_x_title_issue_cover",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "title_id")
//    )
//    public Set<Title> getTitles() {
//        return titles;
//    }
//
//    public void setTitles(Set<Title> titles) {
//        this.titles = titles;
//    }

    @OneToMany(mappedBy = "user")
    public Set<UserSocialNetwork> getUserSocialNetworks() {
        return userSocialNetworks;
    }

    public void setUserSocialNetworks(Set<UserSocialNetwork> userSocialNetworks) {
        this.userSocialNetworks = userSocialNetworks;
    }

    @OneToMany(mappedBy = "userPublisherTitleIssueCoverPK.user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("userPublisherTitleIssueCoverPK.publisher desc")
    public Set<UserPublisherTitleIssueCover> getUserPublisherTitleIssueCovers() {
        return userPublisherTitleIssueCovers;
    }

    public void setUserPublisherTitleIssueCovers(Set<UserPublisherTitleIssueCover> userPublisherTitleIssueCovers) {
        this.userPublisherTitleIssueCovers = userPublisherTitleIssueCovers;
    }

    @Override
    public int compareTo(User o) {
        return (int) (id - o.getId());
    }
}

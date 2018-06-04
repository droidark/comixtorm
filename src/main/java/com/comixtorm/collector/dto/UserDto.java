package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Comparable<UserDto> {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String cover;
    private String aboutYou;
    private Date signUpDate;
    private String status;
    private Set<ProfileDto> profiles;
    private Set<TitleDto> titles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ProfileDto> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<ProfileDto> profiles) {
        this.profiles = profiles;
    }

    public Set<TitleDto> getTitles() {
        return titles;
    }

    public void setTitles(Set<TitleDto> titles) {
        this.titles = titles;
    }

    @Override
    public int compareTo(UserDto o) {
        return (int) (id - o.getId());
    }
}

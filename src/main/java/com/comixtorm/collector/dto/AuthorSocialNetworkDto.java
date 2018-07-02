package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorSocialNetworkDto implements Comparable<AuthorSocialNetworkDto> {
    private Long id;
    private String socialNetworkName;
    private String socialNetworkNickname;
    private String socialNetworkUrl;
    private AuthorDto author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialNetworkName() {
        return socialNetworkName;
    }

    public void setSocialNetworkName(String socialNetworkName) {
        this.socialNetworkName = socialNetworkName;
    }

    public String getSocialNetworkNickname() {
        return socialNetworkNickname;
    }

    public void setSocialNetworkNickname(String socialNetworkNickname) {
        this.socialNetworkNickname = socialNetworkNickname;
    }

    public String getSocialNetworkUrl() {
        return socialNetworkUrl;
    }

    public void setSocialNetworkUrl(String socialNetworkUrl) {
        this.socialNetworkUrl = socialNetworkUrl;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    @Override
    public int compareTo(AuthorSocialNetworkDto o) {
        return (int) (id - o.getId());
    }
}

package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.*;
import com.comixtorm.collector.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ConverterService {
    //  USER CONVERTERS
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);

    //  PROFILE CONVERTERS
    ProfileDto toProfileDto(Profile profile);
    List<ProfileDto> toProfileDtoList(Set<Profile> profiles);

    Profile toProfile(ProfileDto profileDto);
    Set<Profile> toProfileSet(List<ProfileDto> profileDtoList);

    // USER SOCIAL NETWORK CONVERTERS
    UserSocialNetworkDto toUserSocialNetworkDto(UserSocialNetwork userSocialNetwork);
    List<UserSocialNetworkDto> toUserSocialNetworkDtoList(Set<UserSocialNetwork> userSocialNetworks);

    UserSocialNetwork toUserSocialNetwork(UserSocialNetworkDto userSocialNetworkDto);
    Set<UserSocialNetwork> toUserSocialNetworkSet(List<UserSocialNetworkDto> userSocialNetworkDtoList);


    //  AUTHOR CONVERTERS
    AuthorDto toAuthorDto(Author author, boolean setIssueList, boolean setRoleList, boolean setAuthorSNList);
    List<AuthorDto> toAuthorDtoList(Set<Author> authors, boolean setIssueList, boolean setRoleList,
                                    boolean setAuthorSNList);

    Author toAuthor(AuthorDto authorDto, boolean setIssueSet, boolean setRolesSet, boolean setAuthorSNSet);
    Set<Author> toAuthorSet(List<AuthorDto> authorDtoList, boolean setIssueSet, boolean setRolesSet,
                            boolean setAuthorSNSet);

    //  AUTHOR SOCIAL NETWORK CONVERTERS
    AuthorSocialNetworkDto toAuthorSocialNetworkDto(AuthorSocialNetwork authorSocialNetwork, boolean setAuthor,
                                                    boolean setRoleList);
    List<AuthorSocialNetworkDto> toAuthorSocialNetworkDtoList(Set<AuthorSocialNetwork> authorSocialNetworks,
                                                              boolean setAuthor, boolean setRoleList);

    AuthorSocialNetwork toAuthorSocialNetwork(AuthorSocialNetworkDto authorSocialNetworkDto,
                                              boolean setAuthorDto);
    Set<AuthorSocialNetwork> toAuthorSocialNetworkSet(List<AuthorSocialNetworkDto> authorSocialNetworkDtoList,
                                                      boolean setAuthorDto);
    //  ROLE CONVERTERS
    RoleDto toRoleDto(Role role, boolean setAuthorList, boolean setAuthorSNList);
    List<RoleDto> toRoleDtoList(Set<Role> roles, boolean setAuthorList, boolean setAuthorSNList);

    Role toRole(RoleDto roleDto, boolean setAuthorSet, boolean setAuthorSNSet);
    Set<Role> toRoleSet(List<RoleDto> roleDtoList, boolean setAuthorSet, boolean setAuthorSNSet);

    //  PUBLISHER CONVERTERS
    PublisherDto toPublisherDto(Publisher publisher, boolean setTitleList, boolean setPublisherSocialNetworkList,
                                boolean setIssueList);
    List<PublisherDto> toPublisherDtoList(Set<Publisher> publishers, boolean setTitleList,
                                          boolean setPublisherSocialNetworkList, boolean setIssueList);

    Publisher toPublisher(PublisherDto publisherDto, boolean setTitleSet, boolean setPublisherSocialNetworksSet);
    Set<Publisher> toPublisherSet(List<PublisherDto> publisherDtoList, boolean setTitleSet,
                                  boolean setPublisherSocialNetworksSet);

    //  PUBLISHER SOCIAL NETWORK CONVERTERS
    PublisherSocialNetworkDto toPublisherSocialNetworkDto(PublisherSocialNetwork publisherSocialNetwork,
                                                          boolean setPublisher);
    List<PublisherSocialNetworkDto> toPublisherSocialNetworkDtoList(
            Set<PublisherSocialNetwork> publisherSocialNetworks,
            boolean setPublisher);

    PublisherSocialNetwork toPublisherSocialNetwork(PublisherSocialNetworkDto publisherSocialNetworkDto,
                                                    boolean setPublisherSet);
    Set<PublisherSocialNetwork> toPublisherSocialNetworkSet(
            List<PublisherSocialNetworkDto> publisherSocialNetworkDtoList,
            boolean setPublisherSet);

    //  TITLE CONVERTERS
    TitleDto toTitleDto(Title title, boolean setPublisher, boolean setPublisherSocialNetworkList, boolean setIssueList);
    List<TitleDto> toTitleDtoList(Set<Title> titles, boolean setPublisher, boolean setPublisherSocialNetworkList,
                                  boolean setIssueList);

    Title toTitle(TitleDto titleDto, boolean setPublisher, boolean setPublisherSocialNetworkList);
    Set<Title> toTitleSet(List<TitleDto> titleDtoList, boolean setPublisher, boolean setPublisherSocialNetworkList);

    //  ISSUE CONVERTERS
    IssueDto toIssueDto(Issue issue, boolean setPublisher, boolean setTitle, boolean setCoverList, boolean setAuthorList, boolean setCollected);
    List<IssueDto> toIssueDtoList(Set<Issue> issues, boolean setPublisher, boolean setTitle, boolean setCoverList, boolean setAuthorList, boolean setCollected);

    Issue toIssue(IssueDto issueDto, boolean setTitle, boolean setAuthorSet);
    Set<Issue> toIssueSet(List<IssueDto> issueDtoList, boolean setTitle, boolean setAuthorSet);

    //  COVER CONVERTERS
    CoverDto toCoverDto(Cover cover, boolean setIssueDto, boolean setCollected);
    List<CoverDto> toCoverList(Set<Cover> covers, boolean setIssueDto, boolean setCollected);

    Cover toCover(CoverDto coverDto, boolean setIssue);
    Set<Cover> toCoverSet(List<CoverDto> coverDtoList, boolean setIssue);
}

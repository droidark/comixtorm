package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.*;
import com.comixtorm.collector.model.*;

import java.util.Set;

public interface ConverterService {
    UserDto convertToUserDto(User user, boolean profile, boolean title, boolean issue, boolean socialNetwork);
    User convertToUser(UserDto userDto, boolean profile, boolean title, boolean issue, boolean socialNetwork);
    Set<UserDto> convertToSetUserDto(Set<User> userSet, boolean profile, boolean title, boolean issue, boolean socialNetwork);
    Set<User> convertToSetUser(Set<UserDto> userDtoSet, boolean profile, boolean title, boolean issue, boolean socialNetwork);

    ProfileDto convertToProfileDto(Profile profile, boolean user);
    Profile convertToProfile(ProfileDto profileDto, boolean user);
    Set<ProfileDto> convertToSetProfileDto(Set<Profile> profileSet, boolean user);
    Set<Profile> convertToSetProfile(Set<ProfileDto> profileDtoSet, boolean user);

    PublisherDto convertToPublisherDto(Publisher publisher, boolean title, boolean issue, boolean userIssue);
    Publisher convertToPublisher(PublisherDto publisherDto, boolean title, boolean issue, boolean userIssue);
    Set<PublisherDto> convertToSetPublisherDto(Set<Publisher> publisherSet, boolean title, boolean issue, boolean userIssue);
    Set<Publisher> convertToSetPublisher(Set<PublisherDto> publisherDtoSet, boolean title, boolean issue, boolean userIssue);

    PublisherSocialNetworkDto convertToPublisherSocialNetworkDto(PublisherSocialNetwork publisherSocialNetwork);
    PublisherSocialNetwork convertToPublisherSocialNetwork(PublisherSocialNetworkDto publisherSocialNetworkDto);
    Set<PublisherSocialNetworkDto> convertToSetPublisherSocialNetworkDto(Set<PublisherSocialNetwork> publisherSocialNetworkSet);
    Set<PublisherSocialNetwork> convertToSetPublisherSocialNetwork(Set<PublisherSocialNetworkDto> publisherSocialNetworkDtoSet);

    TitleDto convertToTitleDto(Title title, boolean issue, boolean userIssue, boolean user, boolean socialNetwork, boolean collected);
    Title convertToTitle(TitleDto titleDto, boolean issue, boolean userIssue, boolean user, boolean socialNetwork);
    Set<TitleDto> convertToSetTitleDto(Set<Title> titleSet, boolean issue, boolean userIssue, boolean user, boolean socialNetwork, boolean collected);
    Set<Title> convertToSetTitle(Set<TitleDto> titleDtoSet, boolean issue, boolean userIssue, boolean user, boolean socialNetwork);

    IssueDto convertToIssueDto(Issue issue, boolean title, boolean cover, boolean userCover, boolean author, boolean collected);
    Issue convertToIssue(IssueDto issueDto, boolean title, boolean cover, boolean userCover, boolean author);
    Set<IssueDto> convertToSetIssueDto(Set<Issue> issueSet, boolean title, boolean cover, boolean userCover, boolean author, boolean collected);
    Set<Issue> convertToSetIssue(Set<IssueDto> issueDtoSet, boolean title, boolean cover, boolean userCover, boolean author);

    CoverDto convertToCoverDto(Cover cover, boolean title, boolean issue, boolean collected);
    Cover convertToCover(CoverDto coverDto, boolean title, boolean issue);
    Set<CoverDto> convertToSetCoverDto(Set<Cover> coverSet, boolean title, boolean issue, boolean collected);
    Set<Cover> convertToSetCover(Set<CoverDto> coverDtoSet, boolean title, boolean issue);

    AuthorDto convertToAuthorDto(Author author, boolean role);
    Author convertToAuthor(AuthorDto authorDto, boolean role);
    Set<AuthorDto> convertToSetAuthorDto(Set<Author> authorSet, boolean role);
    Set<Author> convertToSetAuthor(Set<AuthorDto> authorDtoSet, boolean role);

    RoleDto convertToRoleDto(Role role, boolean issue, boolean author);
    Role convertToRole(RoleDto roleDto, boolean issue, boolean author);
    Set<RoleDto> convertToSetRoleDto(Set<Role> roleSet, boolean issue, boolean author);
    Set<Role> convertToSetRole(Set<RoleDto> roleDtoSet, boolean issue, boolean author);

    AuthorSocialNetworkDto convertToAuthorSocialNetworkDto(AuthorSocialNetwork authorSocialNetwork, boolean author);
    AuthorSocialNetwork convertToAuthorSocialNetwork(AuthorSocialNetworkDto authorSocialNetworkDto, boolean author);
    Set<AuthorSocialNetworkDto> convertToSetAuthorSocialNetworkDto(Set<AuthorSocialNetwork> authorSocialNetworkSet, boolean author);
    Set<AuthorSocialNetwork> convertToSetAuthorSocialNetwork(Set<AuthorSocialNetworkDto> authorSocialNetworkDtoSet, boolean author);

    UserSocialNetworkDto convertToUserSocialNetworkDto(UserSocialNetwork userSocialNetwork, boolean user);
    UserSocialNetwork convertToUserSocialNetwork(UserSocialNetworkDto userSocialNetworkDto, boolean user);
    Set<UserSocialNetworkDto> convertToSetUserSocialNetworkDto(Set<UserSocialNetwork> userSocialNetworkSet, boolean user);
    Set<UserSocialNetwork> convertToSetUserSocialNetwork(Set<UserSocialNetworkDto> userSocialNetworkDtoSet, boolean user);
}

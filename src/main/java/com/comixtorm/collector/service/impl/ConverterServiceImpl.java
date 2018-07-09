package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.dto.*;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.service.ConverterService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service("converterService")
public class ConverterServiceImpl implements ConverterService {
//    @Override
//    public UserDto convertToUserDto(User user, boolean profile, boolean title, boolean issue, boolean socialNetwork) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setUsername(user.getUsername());
//        userDto.setPassword(user.getPassword());
//        userDto.setEmail(user.getEmail());
//        userDto.setAvatar(user.getAvatar());
//        userDto.setCover(user.getCover());
//        userDto.setAboutYou(user.getAboutYou());
//        userDto.setSignUpDate(user.getSignUpDate());
//        userDto.setIpAddress(user.getIpAddress());
//        userDto.setStatus(user.getStatus());
//        userDto.setTitles(title ? convertToSetTitleDto(user.getTitles(), issue, true, false, false, true) : null);
//        userDto.setProfiles(profile ? convertToSetProfileDto(user.getProfiles(), false) : null);
//        userDto.setUserSocialNetworks(socialNetwork ? convertToSetUserSocialNetworkDto(user.getUserSocialNetworks(), false) : null);
//        return userDto;
//    }
//
//    @Override
//    public User convertToUser(UserDto userDto, boolean profile, boolean title, boolean issue, boolean socialNetwork) {
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setAvatar(userDto.getAvatar());
//        user.setCover(userDto.getCover());
//        user.setAboutYou(userDto.getAboutYou());
//        user.setSignUpDate(userDto.getSignUpDate());
//        user.setIpAddress(userDto.getIpAddress());
//        user.setStatus(userDto.getStatus());
//        user.setTitles(title ? convertToSetTitle(userDto.getTitles(), issue, true, false, false) : null);
//        user.setProfiles(profile ? convertToSetProfile(userDto.getProfiles(), false) : null);
//        user.setUserSocialNetworks(socialNetwork ? convertToSetUserSocialNetwork(userDto.getUserSocialNetworks(), false) : null);
//        return user;
//    }
//
//    @Override
//    public Set<UserDto> convertToSetUserDto(Set<User> userSet, boolean profile, boolean title, boolean issue, boolean socialNetwork) {
//        Set<UserDto> userDtoSet = new TreeSet<>();
//        userSet.forEach(user -> userDtoSet.add(convertToUserDto(user, profile, title, issue, socialNetwork)));
//        return userDtoSet;
//    }
//
//    @Override
//    public Set<User> convertToSetUser(Set<UserDto> userDtoSet, boolean profile, boolean title, boolean issue, boolean socialNetwork) {
//        Set<User> userSet = new TreeSet<>();
//        userDtoSet.forEach(userDto -> userSet.add(convertToUser(userDto, profile, title, issue, socialNetwork)));
//        return userSet;
//    }
//
//    @Override
//    public ProfileDto convertToProfileDto(Profile profile, boolean user) {
//        ProfileDto profileDto = new ProfileDto();
//        profileDto.setId(profile.getId());
//        profileDto.setDescription(profile.getDescription());
//        profileDto.setUsers(user ? convertToSetUserDto(profile.getUsers(), false, false, false, false) : null);
//        return profileDto;
//    }
//
//    @Override
//    public Profile convertToProfile(ProfileDto profileDto, boolean user) {
//        Profile profile = new Profile();
//        profile.setId(profileDto.getId());
//        profile.setDescription(profileDto.getDescription());
//        profile.setUsers(user ? convertToSetUser(profileDto.getUsers(), false, false, false, false) : null);
//        return profile;
//    }
//
//    @Override
//    public Set<ProfileDto> convertToSetProfileDto(Set<Profile> profileSet, boolean user) {
//        Set<ProfileDto> profileDtoSet = new TreeSet<>();
//        profileSet.forEach(profile -> profileDtoSet.add(convertToProfileDto(profile, user)));
//        return profileDtoSet;
//    }
//
//    @Override
//    public Set<Profile> convertToSetProfile(Set<ProfileDto> profileDtoSet, boolean user) {
//        Set<Profile> profileSet = new TreeSet<>();
//        profileDtoSet.forEach(profileDto -> profileSet.add(convertToProfile(profileDto, user)));
//        return profileSet;
//    }
//
//    @Override
//    public PublisherDto convertToPublisherDto(Publisher publisher, boolean title, boolean issue, boolean userIssue) {
//        PublisherDto publisherDto = new PublisherDto();
//        publisherDto.setId(publisher.getId());
//        publisherDto.setName(publisher.getName());
//        publisherDto.setVanity(publisher.getVanity());
//        publisherDto.setUrl(publisher.getUrl());
//        publisherDto.setLogo(publisher.getLogo());
//        publisherDto.setInformation(publisher.getInformation());
//        publisherDto.setTitles(title ? convertToSetTitleDto(publisher.getTitles(), issue, userIssue, false, false, false) : null);
//        return publisherDto;
//    }
//
//    @Override
//    public Publisher convertToPublisher(PublisherDto publisherDto, boolean title, boolean issue, boolean userIssue) {
//        Publisher publisher = new Publisher();
//        publisher.setId(publisherDto.getId());
//        publisher.setName(publisherDto.getName());
//        publisher.setVanity(publisherDto.getVanity());
//        publisher.setUrl(publisherDto.getUrl());
//        publisher.setLogo(publisherDto.getLogo());
//        publisher.setInformation(publisherDto.getInformation());
//        publisher.setTitles(title ? convertToSetTitle(publisherDto.getTitles(), issue, userIssue, false, false) : null);
//        return publisher;
//    }
//
//    @Override
//    public Set<PublisherDto> convertToSetPublisherDto(Set<Publisher> publisherSet, boolean title, boolean issue, boolean userIssue) {
//        Set<PublisherDto> publisherDtoSet = new TreeSet<>();
//        publisherSet.forEach(publisher -> publisherDtoSet.add(convertToPublisherDto(publisher, title, issue, userIssue)));
//        return publisherDtoSet;
//    }
//
//    @Override
//    public Set<Publisher> convertToSetPublisher(Set<PublisherDto> publisherDtoSet, boolean title, boolean issue, boolean userIssue) {
//        Set<Publisher> publisherSet = new TreeSet<>();
//        publisherDtoSet.forEach(publisherDto -> publisherSet.add(convertToPublisher(publisherDto, title, issue, userIssue)));
//        return publisherSet;
//    }
//
//    @Override
//    public PublisherSocialNetworkDto convertToPublisherSocialNetworkDto(PublisherSocialNetwork publisherSocialNetwork) {
//        PublisherSocialNetworkDto publisherSocialNetworkDto = new PublisherSocialNetworkDto();
//        publisherSocialNetworkDto.setId(publisherSocialNetwork.getId());
//        publisherSocialNetworkDto.setSocialNetworkName(publisherSocialNetwork.getSocialNetworkName());
//        publisherSocialNetworkDto.setSocialNetworkNickname(publisherSocialNetwork.getSocialNetworkName());
//        publisherSocialNetworkDto.setSocialNetworkUrl(publisherSocialNetwork.getSocialNetworkUrl());
//        publisherSocialNetworkDto.setPublisher(convertToPublisherDto(publisherSocialNetwork.getPublisherSn(), false, false, false));
//        return publisherSocialNetworkDto;
//    }
//
//    @Override
//    public PublisherSocialNetwork convertToPublisherSocialNetwork(PublisherSocialNetworkDto publisherSocialNetworkDto) {
//        PublisherSocialNetwork publisherSocialNetwork = new PublisherSocialNetwork();
//        publisherSocialNetwork.setId(publisherSocialNetworkDto.getId());
//        publisherSocialNetwork.setSocialNetworkName(publisherSocialNetworkDto.getSocialNetworkName());
//        publisherSocialNetwork.setSocialNetworkNickname(publisherSocialNetworkDto.getSocialNetworkName());
//        publisherSocialNetwork.setSocialNetworkUrl(publisherSocialNetworkDto.getSocialNetworkUrl());
//        publisherSocialNetwork.setPublisherSn(convertToPublisher(publisherSocialNetworkDto.getPublisher(), false, false, false));
//        return publisherSocialNetwork;
//    }
//
//    @Override
//    public Set<PublisherSocialNetworkDto> convertToSetPublisherSocialNetworkDto(Set<PublisherSocialNetwork> publisherSocialNetworkSet) {
//        Set<PublisherSocialNetworkDto> publisherSocialNetworkDtoSet = new TreeSet<>();
//        publisherSocialNetworkSet.forEach(publisherSocialNetwork -> publisherSocialNetworkDtoSet.add(convertToPublisherSocialNetworkDto(publisherSocialNetwork)));
//        return publisherSocialNetworkDtoSet;
//    }
//
//    @Override
//    public Set<PublisherSocialNetwork> convertToSetPublisherSocialNetwork(Set<PublisherSocialNetworkDto> publisherSocialNetworkDtoSet) {
//        Set<PublisherSocialNetwork> publisherSocialNetworkSet = new TreeSet<>();
//        publisherSocialNetworkDtoSet.forEach(publisherSocialNetworkDto -> publisherSocialNetworkSet.add(convertToPublisherSocialNetwork(publisherSocialNetworkDto)));
//        return publisherSocialNetworkSet;
//    }
//
//    @Override
//    public TitleDto convertToTitleDto(Title title, boolean issue, boolean userIssue, boolean user, boolean socialNetwork, boolean collected) {
//        TitleDto titleDto = new TitleDto();
//        titleDto.setId(title.getId());
//        titleDto.setName(title.getName());
//        titleDto.setVanity(title.getVanity());
//        titleDto.setAvatar(title.getAvatar());
//        titleDto.setTotalIssues(title.getTotalIssues());
//        titleDto.setLaunchDate(title.getLaunchDate());
//        titleDto.setPublisher(convertToPublisherDto(title.getPublisher(), false, false, false));
//        titleDto.setUsers(user ? convertToSetUserDto(title.getUsers(), false, false, false, socialNetwork) : null);
//        titleDto.setIssues(issue ? convertToSetIssueDto((userIssue ? title.getUserIssues() : title.getIssues()), false, userIssue, userIssue, false, collected) : null);
//        return titleDto;
//    }
//
//    @Override
//    public Title convertToTitle(TitleDto titleDto, boolean issue, boolean userIssue, boolean user, boolean socialNetwork) {
//        Title title = new Title();
//        title.setId(titleDto.getId());
//        title.setName(titleDto.getName());
//        title.setVanity(titleDto.getVanity());
//        title.setAvatar(titleDto.getAvatar());
//        title.setTotalIssues(titleDto.getTotalIssues());
//        title.setLaunchDate(titleDto.getLaunchDate());
//        title.setPublisher(titleDto.getPublisher() != null ? convertToPublisher(titleDto.getPublisher(), false, false, false) : null);
//        if (issue){
//            if (userIssue) {
//                title.setUserIssues(convertToSetIssue(titleDto.getIssues(), false, true, true, false));
//            } else {
//                title.setIssues(convertToSetIssue(titleDto.getIssues(), false, true, false, false));
//            }
//        }
//        return title;
//    }
//
//    @Override
//    public Set<TitleDto> convertToSetTitleDto(Set<Title> titleSet, boolean issue, boolean userIssue, boolean user, boolean socialNetwork, boolean collected) {
//        Set<TitleDto> titleDtoSet = new TreeSet<>();
//        titleSet.forEach(title -> titleDtoSet.add(convertToTitleDto(title, issue, userIssue, user, socialNetwork, collected)));
//        return titleDtoSet;
//    }
//
//    @Override
//    public Set<Title> convertToSetTitle(Set<TitleDto> titleDtoSet, boolean issue, boolean userIssue, boolean user, boolean socialNetwork) {
//        Set<Title> titleSet = new TreeSet<>();
//        titleDtoSet.forEach(titleDto -> titleSet.add(convertToTitle(titleDto, issue, userIssue, user, socialNetwork)));
//        return titleSet;
//    }
//
//    @Override
//    public IssueDto convertToIssueDto(Issue issue, boolean title, boolean cover, boolean userCover, boolean author, boolean collected) {
//        IssueDto issueDto = new IssueDto();
//        issueDto.setId(issue.getId());
//        issueDto.setName(issue.getName());
//        issueDto.setVanity(issue.getVanity());
//        issueDto.setNumber(issue.getNumber());
//        issueDto.setPrintPrice(issue.getPrintPrice());
//        issueDto.setDigitalPrice(issue.getDigitalPrice());
//        issueDto.setCurrency(issue.getCurrency());
//        issueDto.setPublishedDate(issue.getPublishedDate());
//        issueDto.setShortReview(issue.getShortReview());
//        issueDto.setEvent(issue.getEvent());
//        issueDto.setStoryArch(issue.getStoryArch());
//        issueDto.setIsbn(issue.getIsbn());
//        issueDto.setCollected(collected);
//        issueDto.setTitle(title ? convertToTitleDto(issue.getTitle(), false, false, false, false, collected) : null);
//        issueDto.setCovers(cover ? convertToSetCoverDto((userCover ? issue.getUserCovers() : issue.getCovers()), false, false, collected) : null);
//        issueDto.setAuthors(author ? convertToSetAuthorDto(issue.getAuthors(), true) : null);
//        return issueDto;
//    }
//
//    @Override
//    public Issue convertToIssue(IssueDto issueDto, boolean title, boolean cover, boolean userCover, boolean author) {
//        Issue issue = new Issue();
//        issue.setId(issueDto.getId());
//        issue.setName(issueDto.getName());
//        issue.setVanity(issueDto.getVanity());
//        issue.setNumber(issueDto.getNumber());
//        issue.setPrintPrice(issueDto.getPrintPrice());
//        issue.setDigitalPrice(issueDto.getDigitalPrice());
//        issue.setCurrency(issueDto.getCurrency());
//        issue.setPublishedDate(issueDto.getPublishedDate());
//        issue.setShortReview(issueDto.getShortReview());
//        issue.setEvent(issueDto.getEvent());
//        issue.setStoryArch(issueDto.getStoryArch());
//        issue.setIsbn(issueDto.getIsbn());
//        issue.setAuthors(author ? convertToSetAuthor(issueDto.getAuthors(), true) : null);
//        issue.setTitle(title ? convertToTitle(issueDto.getTitle(), false, false, false, false) : null);
//        if(cover) {
//            if(userCover) {
//                issue.setUserCovers(convertToSetCover(issueDto.getCovers(), false, false));
//            } else {
//                issue.setCovers(convertToSetCover(issueDto.getCovers(), false, false));
//            }
//        }
//        return issue;
//    }
//
//    @Override
//    public Set<IssueDto> convertToSetIssueDto(Set<Issue> issueSet, boolean title, boolean cover, boolean userCover, boolean author, boolean collected) {
//        Set<IssueDto> issueDtoSet = new TreeSet<>();
//        issueSet.forEach(issue -> issueDtoSet.add(convertToIssueDto(issue, title, cover, userCover, author, collected)));
//        return issueDtoSet;
//    }
//
//    @Override
//    public Set<Issue> convertToSetIssue(Set<IssueDto> issueDtoSet, boolean title, boolean cover, boolean userCover, boolean author) {
//        Set<Issue> issueSet = new TreeSet<>();
//        issueDtoSet.forEach(issueDto -> issueSet.add(convertToIssue(issueDto, title, cover, userCover, author)));
//        return issueSet;
//    }
//
//    @Override
//    public CoverDto convertToCoverDto(Cover cover, boolean title, boolean issue, boolean collected) {
//        CoverDto coverDto = new CoverDto();
//        coverDto.setId(cover.getId());
//        coverDto.setCoverImageUrl(cover.getCoverImageUrl());
//        coverDto.setIssue(issue ? convertToIssueDto(cover.getIssue(), title, false, false, title, collected) : null);
//        return coverDto;
//    }
//
//    @Override
//    public Cover convertToCover(CoverDto coverDto, boolean title, boolean issue) {
//        Cover cover = new Cover();
//        cover.setId(coverDto.getId());
//        cover.setCoverImageUrl(coverDto.getCoverImageUrl());
//        cover.setIssue(issue ? convertToIssue(coverDto.getIssue(), title, false, false, title) : null);
//        return cover;
//    }
//
//    @Override
//    public Set<CoverDto> convertToSetCoverDto(Set<Cover> coverSet, boolean title, boolean issue, boolean collected) {
//        Set<CoverDto> coverDtoSet = new TreeSet<>();
//        coverSet.forEach(cover -> coverDtoSet.add(convertToCoverDto(cover, title, issue, collected)));
//        return coverDtoSet;
//    }
//
//    @Override
//    public Set<Cover> convertToSetCover(Set<CoverDto> coverDtoSet, boolean title, boolean issue) {
//        Set<Cover> coverSet = new TreeSet<>();
//        coverDtoSet.forEach(coverDto -> coverSet.add(convertToCover(coverDto, title, issue)));
//        return coverSet;
//    }
//
//    @Override
//    public AuthorDto convertToAuthorDto(Author author, boolean role) {
//        AuthorDto authorDto = new AuthorDto();
//        authorDto.setId(author.getId());
//        authorDto.setName(author.getName());
//        authorDto.setAvatar(author.getAvatar());
//        authorDto.setBiography(author.getBiography());
//        authorDto.setRoles(role ? convertToSetRoleDto(author.getRoles(), false, false) : null);
//        return authorDto;
//    }
//
//    @Override
//    public Author convertToAuthor(AuthorDto authorDto, boolean role) {
//        Author author = new Author();
//        author.setId(authorDto.getId());
//        author.setName(authorDto.getName());
//        author.setAvatar(authorDto.getAvatar());
//        author.setBiography(authorDto.getBiography());
//        author.setRoles(role ? convertToSetRole(authorDto.getRoles(), false, false) : null);
//        return author;
//    }
//
//    @Override
//    public Set<AuthorDto> convertToSetAuthorDto(Set<Author> authorSet, boolean role) {
//        Set<AuthorDto> authorDtoSet = new TreeSet<>();
//        authorSet.forEach(author -> authorDtoSet.add(convertToAuthorDto(author, role)));
//        return authorDtoSet;
//    }
//
//    @Override
//    public Set<Author> convertToSetAuthor(Set<AuthorDto> authorDtoSet, boolean role) {
//        Set<Author> authorSet = new TreeSet<>();
//        authorDtoSet.forEach(authorDto -> authorSet.add(convertToAuthor(authorDto, role)));
//        return authorSet;
//    }
//
//    @Override
//    public RoleDto convertToRoleDto(Role role, boolean issue, boolean author) {
//        RoleDto roleDto = new RoleDto();
//        roleDto.setId(role.getId());
//        roleDto.setDescription(role.getDescription());
//        roleDto.setAuthors(author ? convertToSetAuthorDto(role.getAuthors(), false) : null);
//        return roleDto;
//    }
//
//    @Override
//    public Role convertToRole(RoleDto roleDto, boolean issue, boolean author) {
//        Role role = new Role();
//        role.setId(roleDto.getId());
//        role.setDescription(roleDto.getDescription());
//        role.setAuthors(author ? convertToSetAuthor(roleDto.getAuthors(), false) : null);
//        return role;
//    }
//
//    @Override
//    public Set<RoleDto> convertToSetRoleDto(Set<Role> roleSet, boolean issue, boolean author) {
//        Set<RoleDto> roleDtoSet = new TreeSet<>();
//        roleSet.forEach(role -> roleDtoSet.add(convertToRoleDto(role, issue, author)));
//        return roleDtoSet;
//    }
//
//    @Override
//    public Set<Role> convertToSetRole(Set<RoleDto> roleDtoSet, boolean issue, boolean author) {
//        Set<Role> roleSet = new TreeSet<>();
//        roleDtoSet.forEach(roleDto -> roleSet.add(convertToRole(roleDto, issue, author)));
//        return roleSet;
//    }
//
//    @Override
//    public AuthorSocialNetworkDto convertToAuthorSocialNetworkDto(AuthorSocialNetwork authorSocialNetwork, boolean author) {
//        AuthorSocialNetworkDto authorSocialNetworkDto = new AuthorSocialNetworkDto();
//        authorSocialNetworkDto.setId(authorSocialNetwork.getId());
//        authorSocialNetworkDto.setSocialNetworkName(authorSocialNetwork.getSocialNetworkName());
//        authorSocialNetworkDto.setSocialNetworkNickname(authorSocialNetwork.getSocialNetworkNickname());
//        authorSocialNetworkDto.setSocialNetworkUrl(authorSocialNetwork.getSocialNetworkUrl());
//        authorSocialNetworkDto.setAuthor(author ? convertToAuthorDto(authorSocialNetwork.getAuthor(), false) : null);
//        return authorSocialNetworkDto;
//    }
//
//    @Override
//    public AuthorSocialNetwork convertToAuthorSocialNetwork(AuthorSocialNetworkDto authorSocialNetworkDto, boolean author) {
//        AuthorSocialNetwork authorSocialNetwork = new AuthorSocialNetwork();
//        authorSocialNetwork.setId(authorSocialNetworkDto.getId());
//        authorSocialNetwork.setSocialNetworkName(authorSocialNetworkDto.getSocialNetworkName());
//        authorSocialNetwork.setSocialNetworkNickname(authorSocialNetworkDto.getSocialNetworkNickname());
//        authorSocialNetwork.setSocialNetworkUrl(authorSocialNetworkDto.getSocialNetworkUrl());
//        authorSocialNetwork.setAuthor(author ? convertToAuthor(authorSocialNetworkDto.getAuthor(), false) : null);
//        return authorSocialNetwork;
//    }
//
//    @Override
//    public Set<AuthorSocialNetworkDto> convertToSetAuthorSocialNetworkDto(Set<AuthorSocialNetwork> authorSocialNetworkSet, boolean author) {
//        Set<AuthorSocialNetworkDto> authorSocialNetworkDtoSet = new TreeSet<>();
//        authorSocialNetworkSet.forEach(authorSocialNetwork -> authorSocialNetworkDtoSet.add(convertToAuthorSocialNetworkDto(authorSocialNetwork, author)));
//        return authorSocialNetworkDtoSet;
//    }
//
//    @Override
//    public Set<AuthorSocialNetwork> convertToSetAuthorSocialNetwork(Set<AuthorSocialNetworkDto> authorSocialNetworkDtoSet, boolean author) {
//        Set<AuthorSocialNetwork> authorSocialNetworkSet = new TreeSet<>();
//        authorSocialNetworkDtoSet.forEach(authorSocialNetworkDto -> authorSocialNetworkSet.add(convertToAuthorSocialNetwork(authorSocialNetworkDto, author)));
//        return authorSocialNetworkSet;
//    }
//
//    @Override
//    public UserSocialNetworkDto convertToUserSocialNetworkDto(UserSocialNetwork userSocialNetwork, boolean user) {
//        UserSocialNetworkDto userSocialNetworkDto = new UserSocialNetworkDto();
//        userSocialNetworkDto.setId(userSocialNetwork.getId());
//        userSocialNetworkDto.setSocialNetworkName(userSocialNetwork.getSocialNetworkName());
//        userSocialNetworkDto.setSocialNetworkNickname(userSocialNetwork.getSocialNetworkNickname());
//        userSocialNetworkDto.setSocialNetworkUrl(userSocialNetwork.getSocialNetworkUrl());
//        userSocialNetworkDto.setUser(user ? convertToUserDto(userSocialNetwork.getUser(), false, false, false, false) : null);
//        return userSocialNetworkDto;
//    }
//
//    @Override
//    public UserSocialNetwork convertToUserSocialNetwork(UserSocialNetworkDto userSocialNetworkDto, boolean user) {
//        UserSocialNetwork userSocialNetwork = new UserSocialNetwork();
//        userSocialNetwork.setId(userSocialNetworkDto.getId());
//        userSocialNetwork.setSocialNetworkName(userSocialNetworkDto.getSocialNetworkName());
//        userSocialNetwork.setSocialNetworkNickname(userSocialNetworkDto.getSocialNetworkNickname());
//        userSocialNetwork.setSocialNetworkUrl(userSocialNetworkDto.getSocialNetworkUrl());
//        userSocialNetwork.setUser(user ? convertToUser(userSocialNetworkDto.getUser(), false, false, false, false) : null);
//        return userSocialNetwork;
//    }
//
//    @Override
//    public Set<UserSocialNetworkDto> convertToSetUserSocialNetworkDto(Set<UserSocialNetwork> userSocialNetworkSet, boolean user) {
//        Set<UserSocialNetworkDto> userSocialNetworkDtoSet = new TreeSet<>();
//        userSocialNetworkSet.forEach(userSocialNetwork -> userSocialNetworkDtoSet.add(convertToUserSocialNetworkDto(userSocialNetwork, user)));
//        return userSocialNetworkDtoSet;
//    }
//
//    @Override
//    public Set<UserSocialNetwork> convertToSetUserSocialNetwork(Set<UserSocialNetworkDto> userSocialNetworkDtoSet, boolean user) {
//        Set<UserSocialNetwork> userSocialNetworkSet = new TreeSet<>();
//        userSocialNetworkDtoSet.forEach(userSocialNetworkDto -> userSocialNetworkSet.add(convertToUserSocialNetwork(userSocialNetworkDto, user)));
//        return userSocialNetworkSet;
//    }
}

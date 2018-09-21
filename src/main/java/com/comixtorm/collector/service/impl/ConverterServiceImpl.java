package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.dto.*;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.service.ConverterService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("converterService")
public class ConverterServiceImpl implements ConverterService {
    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(null);
        userDto.setEmail(user.getEmail());
        userDto.setAvatar(user.getAvatar());
        userDto.setCover(user.getCover());
        userDto.setAboutYou(user.getAboutYou());
        userDto.setSignUpDate(user.getSignUpDate());
        userDto.setIpAddress(user.getIpAddress());
        userDto.setStatus(user.getStatus());
        userDto.setProfiles(toProfileDtoList(user.getProfiles()));
        userDto.setUserSocialNetworks(toUserSocialNetworkDtoList(user.getUserSocialNetworks()));
        userDto.setPublishers(new ArrayList<>());

        PublisherDto publisherDto;
        TitleDto titleDto;
        IssueDto issueDto;
        CoverDto coverDto;

        //  GET COLLECTION
        for(UserPublisherTitleIssueCover userPublisherTitleIssueCover : user.getUserPublisherTitleIssueCovers()) {
            //  PUBLISHER
            publisherDto = toPublisherDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getPublisher(), false, false, false);
            publisherDto.setTitles(new ArrayList<>());
            if(!userDto.getPublishers().contains(publisherDto)) {
                userDto.getPublishers().add(publisherDto);
            }

            //  ISSUE
            issueDto = toIssueDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getIssue(), false, true,true, true, true);

            //  COVER
            coverDto = toCoverDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getCover(), true, true);

            //  TITLE
            titleDto = toTitleDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getTitle(), true, false, true);
            if(userDto.getPublishers().contains(titleDto.getPublisher())) {
                publisherDto = titleDto.getPublisher();
                titleDto.setPublisher(null);
                int publisherIndex = userDto.getPublishers().indexOf(publisherDto);

                if(!userDto.getPublishers().get(publisherIndex).getTitles().contains(titleDto)) {
                    userDto.getPublishers().get(publisherIndex).getTitles().add(titleDto);
                }
                int titleIndex = (userDto.getPublishers().get(publisherIndex).getTitles().indexOf(titleDto));

                int issueIndex = userDto
                        .getPublishers()
                        .get(publisherIndex)
                        .getTitles()
                        .get(titleIndex)
                        .getIssues()
                        .indexOf(issueDto);

                int coverIndex = userDto.getPublishers().get(publisherIndex)
                        .getTitles().get(titleIndex).getIssues().get(issueIndex).getCovers().indexOf(coverDto);

                userDto
                        .getPublishers()
                        .get(publisherIndex)
                        .getTitles()
                        .get(titleIndex)
                        .getIssues().get(issueIndex).setCollected(true);

                userDto
                        .getPublishers()
                        .get(publisherIndex)
                        .getTitles()
                        .get(titleIndex)
                        .getIssues().get(issueIndex).getCovers().get(coverIndex).setCollected(true);
            }
        }
        Collections.sort(userDto.getPublishers());
        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setCover(userDto.getCover());
        user.setAboutYou(userDto.getAboutYou());
        user.setSignUpDate(userDto.getSignUpDate());
        user.setIpAddress(userDto.getIpAddress());
        user.setStatus(userDto.getStatus());
//        user.setProfiles(toProfileSet(userDto.getProfiles()));
//        user.setUserSocialNetworks(toUserSocialNetworkSet(userDto.getUserSocialNetworks()));
        return user;
    }

    @Override
    public ProfileDto toProfileDto(Profile profile) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setDescription(profile.getDescription());
        return profileDto;
    }

    @Override
    public List<ProfileDto> toProfileDtoList(Set<Profile> profiles) {
        List<ProfileDto> profileDtoList = new ArrayList<>();
        for(Profile profile : profiles) {
            profileDtoList.add(toProfileDto(profile));
        }
        return profileDtoList;
    }

    @Override
    public Profile toProfile(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setId(profileDto.getId());
        profile.setDescription(profileDto.getDescription());
        return profile;
    }

    @Override
    public Set<Profile> toProfileSet(List<ProfileDto> profileDtoList) {
        Set<Profile> profileSet = new TreeSet<>();
        for(ProfileDto profileDto : profileDtoList) {
            profileSet.add(toProfile(profileDto));
        }
        return profileSet;
    }

    @Override
    public UserSocialNetworkDto toUserSocialNetworkDto(UserSocialNetwork userSocialNetwork) {
        UserSocialNetworkDto userSocialNetworkDto = new UserSocialNetworkDto();
        userSocialNetworkDto.setId(userSocialNetwork.getId());
        userSocialNetworkDto.setSocialNetworkName(userSocialNetwork.getSocialNetworkName());
        userSocialNetworkDto.setSocialNetworkNickname(userSocialNetwork.getSocialNetworkNickname());
        userSocialNetworkDto.setSocialNetworkUrl(userSocialNetwork.getSocialNetworkUrl());
        return userSocialNetworkDto;
    }

    @Override
    public List<UserSocialNetworkDto> toUserSocialNetworkDtoList(Set<UserSocialNetwork> userSocialNetworks) {
        List<UserSocialNetworkDto> userSocialNetworkDtoList = new ArrayList<>();
        for(UserSocialNetwork userSocialNetwork : userSocialNetworks) {
            userSocialNetworkDtoList.add(toUserSocialNetworkDto(userSocialNetwork));
        }
        return userSocialNetworkDtoList;
    }

    @Override
    public UserSocialNetwork toUserSocialNetwork(UserSocialNetworkDto userSocialNetworkDto) {
        UserSocialNetwork userSocialNetwork = new UserSocialNetwork();
        userSocialNetwork.setId(userSocialNetworkDto.getId());
        userSocialNetwork.setSocialNetworkName(userSocialNetworkDto.getSocialNetworkName());
        userSocialNetwork.setSocialNetworkNickname(userSocialNetworkDto.getSocialNetworkNickname());
        userSocialNetwork.setSocialNetworkUrl(userSocialNetworkDto.getSocialNetworkUrl());
        return userSocialNetwork;
    }

    @Override
    public Set<UserSocialNetwork> toUserSocialNetworkSet(List<UserSocialNetworkDto> userSocialNetworkDtoList) {
        Set<UserSocialNetwork> userSocialNetworkSet = new TreeSet<>();
        for(UserSocialNetworkDto userSocialNetworkDto : userSocialNetworkDtoList) {
            userSocialNetworkSet.add(toUserSocialNetwork(userSocialNetworkDto));
        }
        return userSocialNetworkSet;
    }

    @Override
    public AuthorDto toAuthorDto(Author author, boolean setIssueList, boolean setRoleList, boolean setAuthorSNList) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setAvatar(author.getAvatar());
        authorDto.setBiography(author.getBiography());
        authorDto.setIssues(setIssueList
                ? toIssueDtoList(author.getIssues(), false,false, false, false, false)
                : null);
        authorDto.setAuthorSocialNetworks(setAuthorSNList
                ? toAuthorSocialNetworkDtoList(author.getAuthorSocialNetworks(), false, false)
                : null);
        authorDto.setRoles(setRoleList
                ? toRoleDtoList(author.getRoles(), false, false)
                : null);
        return authorDto;
    }

    @Override
    public List<AuthorDto> toAuthorDtoList(Set<Author> authors, boolean setIssueList, boolean setRoleList,
                                           boolean setAuthorSNList) {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for(Author author : authors) {
            authorDtoList.add(toAuthorDto(author, setIssueList, setRoleList, setAuthorSNList));
        }
        return authorDtoList;
    }

    @Override
    public Author toAuthor(AuthorDto authorDto, boolean setIssueSet, boolean setRolesSet, boolean setAuthorSNSet) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setAvatar(authorDto.getAvatar());
        author.setBiography(authorDto.getBiography());
        author.setIssues(setIssueSet
                ? toIssueSet(authorDto.getIssues(), false, false)   // CHECK
                : null);
        author.setAuthorSocialNetworks(setAuthorSNSet ?
                toAuthorSocialNetworkSet(authorDto.getAuthorSocialNetworks(), false) : null);
        author.setRoles(setRolesSet
                ? toRoleSet(authorDto.getRoles(), false, setAuthorSNSet)
                : null);
        return author;
    }

    @Override
    public Set<Author> toAuthorSet(List<AuthorDto> authorDtoList, boolean setIssueSet, boolean setRolesSet,
                                   boolean setAuthorSNSet) {
        Set<Author> authorSet = new TreeSet<>();
        for(AuthorDto authorDto : authorDtoList) {
            authorSet.add(toAuthor(authorDto, setIssueSet, setRolesSet, setAuthorSNSet));
        }
        return authorSet;
    }

    @Override
    public AuthorSocialNetworkDto toAuthorSocialNetworkDto(AuthorSocialNetwork authorSocialNetwork, boolean setAuthor,
                                                           boolean setRoleList) {
        AuthorSocialNetworkDto authorSocialNetworkDto = new AuthorSocialNetworkDto();
        authorSocialNetworkDto.setId(authorSocialNetwork.getId());
        authorSocialNetworkDto.setSocialNetworkName(authorSocialNetwork.getSocialNetworkName());
        authorSocialNetworkDto.setSocialNetworkNickname(authorSocialNetwork.getSocialNetworkNickname());
        authorSocialNetworkDto.setSocialNetworkUrl(authorSocialNetwork.getSocialNetworkUrl());
        authorSocialNetworkDto.setAuthor(setAuthor
                ? toAuthorDto(authorSocialNetwork.getAuthor(), false, setRoleList, false)
                : null);
        return authorSocialNetworkDto;
    }

    @Override
    public List<AuthorSocialNetworkDto> toAuthorSocialNetworkDtoList(Set<AuthorSocialNetwork> authorSocialNetworks,
                                                                     boolean setAuthor, boolean setRoleList) {
        List<AuthorSocialNetworkDto> authorSocialNetworkDtoList = new ArrayList<>();
        for(AuthorSocialNetwork authorSocialNetwork : authorSocialNetworks) {
            authorSocialNetworkDtoList.add(toAuthorSocialNetworkDto(authorSocialNetwork, setAuthor, setRoleList));
        }
        return authorSocialNetworkDtoList;
    }

    @Override
    public AuthorSocialNetwork toAuthorSocialNetwork(AuthorSocialNetworkDto authorSocialNetworkDto,
                                                     boolean setAuthorDto) {
        AuthorSocialNetwork authorSocialNetwork = new AuthorSocialNetwork();
        authorSocialNetwork.setId(authorSocialNetworkDto.getId());
        authorSocialNetwork.setSocialNetworkName(authorSocialNetworkDto.getSocialNetworkName());
        authorSocialNetwork.setSocialNetworkNickname(authorSocialNetworkDto.getSocialNetworkNickname());
        authorSocialNetwork.setSocialNetworkUrl(authorSocialNetworkDto.getSocialNetworkUrl());
        authorSocialNetwork.setAuthor(setAuthorDto
                ? toAuthor(authorSocialNetworkDto.getAuthor(),false, false, false)
                : null);
        return authorSocialNetwork;
    }

    @Override
    public Set<AuthorSocialNetwork> toAuthorSocialNetworkSet(List<AuthorSocialNetworkDto> authorSocialNetworkDtoList,
                                                             boolean setAuthorDto) {
        Set<AuthorSocialNetwork> authorSocialNetworkSet = new TreeSet<>();
        for(AuthorSocialNetworkDto authorSocialNetworkDto : authorSocialNetworkDtoList) {
            authorSocialNetworkSet.add(toAuthorSocialNetwork(authorSocialNetworkDto, setAuthorDto));
        }
        return authorSocialNetworkSet;
    }

    @Override
    public RoleDto toRoleDto(Role role, boolean setAuthorList, boolean setAuthorSNList) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setDescription(role.getDescription());
        roleDto.setAuthors(setAuthorList
                ? toAuthorDtoList(role.getAuthors(), false,false, setAuthorSNList)
                : null);
        return roleDto;
    }

    @Override
    public List<RoleDto> toRoleDtoList(Set<Role> roles, boolean setAuthorList, boolean setAuthorSNList) {
        List<RoleDto> roleDtoList = new ArrayList<>();
        for(Role role : roles) {
            roleDtoList.add(toRoleDto(role, setAuthorList, setAuthorSNList));
        }
        return roleDtoList;
    }

    @Override
    public Role toRole(RoleDto roleDto, boolean setAuthorSet, boolean setAuthorSNSet) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setDescription(roleDto.getDescription());
        role.setAuthors(setAuthorSet
                ? toAuthorSet(roleDto.getAuthors(), false,false, setAuthorSNSet)
                : null);
        return role;
    }

    @Override
    public Set<Role> toRoleSet(List<RoleDto> roleDtoList, boolean setAuthorSet, boolean setAuthorSNSet) {
        Set<Role> roleSet = new TreeSet<>();
        for(RoleDto roleDto : roleDtoList) {
            roleSet.add(toRole(roleDto, setAuthorSet, setAuthorSNSet));
        }
        return roleSet;
    }

    @Override
    public PublisherDto toPublisherDto(Publisher publisher, boolean setTitleList,
                                       boolean setPublisherSocialNetworkList, boolean setIssueList) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(publisher.getId());
        publisherDto.setName(publisher.getName());
        publisherDto.setVanity(publisher.getVanity());
        publisherDto.setUrl(publisher.getUrl());
        publisherDto.setLogo(publisher.getLogo());
        publisherDto.setInformation(publisher.getInformation());
        publisherDto.setTitles(setTitleList
                ? toTitleDtoList(publisher.getTitles(), false, setPublisherSocialNetworkList, setIssueList)
                : null);
        publisherDto.setPublisherSocialNetworks(setPublisherSocialNetworkList ?
                toPublisherSocialNetworkDtoList(publisher.getPublisherSocialNetworks(), false) : null);
        return publisherDto;
    }

    @Override
    public List<PublisherDto> toPublisherDtoList(Set<Publisher> publishers, boolean setTitleList,
                                                 boolean setPublisherSocialNetworkList, boolean setIssueList) {
        List<PublisherDto> publisherDtoList = new ArrayList<>();
        for(Publisher publisher : publishers) {
            publisherDtoList.add(toPublisherDto(publisher, setTitleList, setPublisherSocialNetworkList, setIssueList));
        }
        return publisherDtoList;
    }

    @Override
    public Publisher toPublisher(PublisherDto publisherDto, boolean setTitleSet, boolean setPublisherSocialNetworksSet) {
        Publisher publisher = new Publisher();
        publisher.setId(publisherDto.getId());
        publisher.setName(publisherDto.getName());
        publisher.setVanity(publisherDto.getVanity());
        publisher.setUrl(publisherDto.getUrl());
        publisher.setLogo(publisherDto.getLogo());
        publisher.setInformation(publisherDto.getInformation());
        publisher.setTitles(setTitleSet
                ? toTitleSet(publisherDto.getTitles(), false, setPublisherSocialNetworksSet)
                : null);
        publisher.setPublisherSocialNetworks(setPublisherSocialNetworksSet
                ? toPublisherSocialNetworkSet(publisherDto.getPublisherSocialNetworks(), false)
                : null);
        return publisher;
    }

    @Override
    public Set<Publisher> toPublisherSet(List<PublisherDto> publisherDtoList, boolean setTitleSet,
                                         boolean setPublisherSocialNetworksSet) {
        Set<Publisher> publisherSet = new TreeSet<>();
        for(PublisherDto publisherDto : publisherDtoList) {
            publisherSet.add(toPublisher(publisherDto, setTitleSet, setPublisherSocialNetworksSet));
        }
        return publisherSet;
    }

    @Override
    public PublisherSocialNetworkDto toPublisherSocialNetworkDto(
            PublisherSocialNetwork publisherSocialNetwork,
            boolean setPublisher) {
        PublisherSocialNetworkDto publisherSocialNetworkDto = new PublisherSocialNetworkDto();
        publisherSocialNetworkDto.setId(publisherSocialNetwork.getId());
        publisherSocialNetworkDto.setSocialNetworkName(publisherSocialNetworkDto.getSocialNetworkName());
        publisherSocialNetworkDto.setSocialNetworkNickname(publisherSocialNetwork.getSocialNetworkNickname());
        publisherSocialNetworkDto.setSocialNetworkUrl(publisherSocialNetwork.getSocialNetworkUrl());
        publisherSocialNetworkDto.setPublisher(setPublisher
                ? toPublisherDto(publisherSocialNetwork.getPublisherSn(), false, false, false)
                : null);
        return publisherSocialNetworkDto;
    }

    @Override
    public List<PublisherSocialNetworkDto> toPublisherSocialNetworkDtoList(
            Set<PublisherSocialNetwork> publisherSocialNetworks,
            boolean setPublisher) {
        List<PublisherSocialNetworkDto> publisherSocialNetworkDtoList = new ArrayList<>();
        for(PublisherSocialNetwork publisherSocialNetwork : publisherSocialNetworks) {
            publisherSocialNetworkDtoList.add(toPublisherSocialNetworkDto(publisherSocialNetwork, setPublisher));
        }
        return publisherSocialNetworkDtoList;
    }

    @Override
    public PublisherSocialNetwork toPublisherSocialNetwork(PublisherSocialNetworkDto publisherSocialNetworkDto,
                                                           boolean setPublisherSet) {
        PublisherSocialNetwork publisherSocialNetwork = new PublisherSocialNetwork();
        publisherSocialNetwork.setId(publisherSocialNetworkDto.getId());
        publisherSocialNetwork.setSocialNetworkName(publisherSocialNetworkDto.getSocialNetworkName());
        publisherSocialNetwork.setSocialNetworkNickname(publisherSocialNetworkDto.getSocialNetworkNickname());
        publisherSocialNetwork.setSocialNetworkUrl(publisherSocialNetwork.getSocialNetworkUrl());
        publisherSocialNetwork.setPublisherSn(setPublisherSet
                ? toPublisher(publisherSocialNetworkDto.getPublisher(), false, false)
                : null);
        return publisherSocialNetwork;
    }

    @Override
    public Set<PublisherSocialNetwork> toPublisherSocialNetworkSet(
            List<PublisherSocialNetworkDto> publisherSocialNetworkDtoList,
            boolean setPublisherSet) {
        Set<PublisherSocialNetwork> publisherSocialNetworkSet = new TreeSet<>();
        for(PublisherSocialNetworkDto publisherSocialNetworkDto : publisherSocialNetworkDtoList) {
            publisherSocialNetworkSet.add(toPublisherSocialNetwork(publisherSocialNetworkDto, setPublisherSet));
        }
        return publisherSocialNetworkSet;
    }

    @Override
    public TitleDto toTitleDto(Title title, boolean setPublisher, boolean setPublisherSocialNetworkList,
                               boolean setIssueList) {
        TitleDto titleDto = new TitleDto();
        titleDto.setId(title.getId());
        titleDto.setName(title.getName());
        titleDto.setVanity(title.getVanity());
        titleDto.setAvatar(title.getAvatar());
        titleDto.setTotalIssues(title.getTotalIssues());
        titleDto.setLaunchDate(title.getLaunchDate());
        titleDto.setPublisher(setPublisher
                ? toPublisherDto(title.getPublisher(), false, setPublisherSocialNetworkList, false)
                : null);
        titleDto.setIssues(setIssueList
                ? toIssueDtoList(title.getIssues(), setPublisher,false, true, true, false)
                : null);
        return titleDto;
    }

    @Override
    public List<TitleDto> toTitleDtoList(Set<Title> titles, boolean setPublisher,
                                         boolean setPublisherSocialNetworkList, boolean setIssueList) {
        List<TitleDto> titleDtoList = new ArrayList<>();
        for(Title title : titles) {
            titleDtoList.add(toTitleDto(title, setPublisher, setPublisherSocialNetworkList, setIssueList));
        }
        return titleDtoList;
    }

    @Override
    public Title toTitle(TitleDto titleDto, boolean setPublisher, boolean setPublisherSocialNetworkList) {
        Title title = new Title();
        title.setId(titleDto.getId());
        title.setName(titleDto.getName());
        title.setVanity(titleDto.getVanity());
        title.setAvatar(titleDto.getAvatar());
        title.setTotalIssues(titleDto.getTotalIssues());
        title.setLaunchDate(titleDto.getLaunchDate());
        title.setPublisher(setPublisher
                ? toPublisher(titleDto.getPublisher(), false,setPublisherSocialNetworkList)
                : null);
        return title;
    }

    @Override
    public Set<Title> toTitleSet(List<TitleDto> titleDtoList, boolean setPublisher,
                                 boolean setPublisherSocialNetworkList) {
        Set<Title> titleSet = new TreeSet<>();
        for(TitleDto titleDto : titleDtoList) {
            titleSet.add(toTitle(titleDto, setPublisher, setPublisherSocialNetworkList));
        }
        return titleSet;
    }

    @Override
    public IssueDto toIssueDto(Issue issue, boolean setPublusher, boolean setTitle, boolean setCoverList, boolean setAuthorList, boolean setCollected) {
        IssueDto issueDto = new IssueDto();
        issueDto.setId(issue.getId());
        issueDto.setName(issue.getName());
        issueDto.setVanity(issue.getVanity());
        issueDto.setNumber(issue.getNumber());
        issueDto.setPrintPrice(issue.getPrintPrice());
        issueDto.setDigitalPrice(issue.getDigitalPrice());
        issueDto.setCurrency(issue.getCurrency());
        issueDto.setPublishedDate(issue.getPublishedDate());
        issueDto.setShortReview(issue.getShortReview());
        issueDto.setEvent(issue.getEvent());
        issueDto.setStoryArch(issue.getStoryArch());
        issueDto.setIsbn(issue.getIsbn());
        issueDto.setCollected(setCollected);
        issueDto.setTitle(setTitle
                ? toTitleDto(issue.getTitle(), setPublusher, false, false)
                : null);
        issueDto.setCovers(setCoverList
                ? toCoverList(issue.getCovers(), false, false)
                : null);
        issueDto.setAuthors(setAuthorList
                ? toAuthorDtoList(issue.getAuthors(), false, true, false)
                : null);
        return issueDto;
    }

    @Override
    public List<IssueDto> toIssueDtoList(Set<Issue> issues, boolean setPublisher, boolean setTitle, boolean setCoverList, boolean setAuthorList, boolean setCollected) {
        List<IssueDto> issueDtoList = new ArrayList<>();
        for(Issue issue : issues) {
            issueDtoList.add(toIssueDto(issue, setPublisher, setTitle, setCoverList, setAuthorList, setCollected));
        }
        return issueDtoList;
    }

    @Override
    public Issue toIssue(IssueDto issueDto, boolean setTitle, boolean setAuthorSet) {
        Issue issue = new Issue();
        issue.setId(issueDto.getId());
        issue.setName(issueDto.getName());
        issue.setVanity(issueDto.getVanity());
        issue.setNumber(issueDto.getNumber());
        issue.setPrintPrice(issueDto.getPrintPrice());
        issue.setDigitalPrice(issueDto.getDigitalPrice());
        issue.setCurrency(issueDto.getCurrency());
        issue.setPublishedDate(issueDto.getPublishedDate());
        issue.setShortReview(issueDto.getShortReview());
        issue.setEvent(issueDto.getEvent());
        issue.setStoryArch(issueDto.getStoryArch());
        issue.setIsbn(issueDto.getIsbn());
        issue.setTitle(setTitle
                ? toTitle(issueDto.getTitle(), false, false)
                : null);
        issue.setAuthors(setAuthorSet
                ? toAuthorSet(issueDto.getAuthors(),false, true, false)
                : null);
        return issue;
    }

    @Override
    public Set<Issue> toIssueSet(List<IssueDto> issueDtoList, boolean setTitle, boolean setAuthorSet) {
        Set<Issue> issueSet = new TreeSet<>();
        for(IssueDto issueDto : issueDtoList) {
            issueSet.add(toIssue(issueDto, setTitle, setAuthorSet));
        }
        return issueSet;
    }

    @Override
    public CoverDto toCoverDto(Cover cover, boolean setIssueDto, boolean setCollected) {
        CoverDto coverDto = new CoverDto();
        coverDto.setId(cover.getId());
        coverDto.setCoverImageUrl(cover.getCoverImageUrl());
        coverDto.setCollected(setCollected);
        coverDto.setIssue(setIssueDto
                ? toIssueDto(cover.getIssue(), false, false,false, false, false)
                : null);
        return coverDto;
    }

    @Override
    public List<CoverDto> toCoverList(Set<Cover> covers, boolean setIssueDto, boolean setCollected) {
        List<CoverDto> coverDtoList = new ArrayList<>();
        for(Cover cover : covers) {
            coverDtoList.add(toCoverDto(cover, setIssueDto, setCollected));
        }
        return coverDtoList;
    }

    @Override
    public Cover toCover(CoverDto coverDto, boolean setIssue) {
        Cover cover = new Cover();
        cover.setId(coverDto.getId());
        cover.setCoverImageUrl(coverDto.getCoverImageUrl());
        cover.setIssue(setIssue
                ? toIssue(coverDto.getIssue(), false, false)
                : null);
        return cover;
    }

    @Override
    public Set<Cover> toCoverSet(List<CoverDto> coverDtoList, boolean setIssue) {
        Set<Cover> coverSet = new TreeSet<>();
        for(CoverDto coverDto : coverDtoList) {
            coverSet.add(toCover(coverDto, setIssue));
        }
        return coverSet;
    }
}

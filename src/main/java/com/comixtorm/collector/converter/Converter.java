package com.comixtorm.collector.converter;

import com.comixtorm.collector.dto.*;
import com.comixtorm.collector.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Converter {
    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(null);
        userDto.setEmail(user.getEmail());
        userDto.setAvatar(user.getAvatar());
        userDto.setCover(user.getCover());
        userDto.setAboutYou(user.getAboutYou());
        userDto.setSignUpDate(user.getSignUpDate());
        userDto.setStatus(user.getStatus());
        userDto.setTitles(listTitleToListTitleDto(user.getTitles(), true));
        return userDto;
    }

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());
        user.setCover(userDto.getCover());
        user.setAboutYou(userDto.getAboutYou());
        user.setSignUpDate(userDto.getSignUpDate());
        user.setStatus(userDto.getStatus());
        return user;
    }

    public static PublisherDto publisherToPublisherDto(Publisher publisher) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(publisher.getId());
        publisherDto.setName(publisher.getName());
        publisherDto.setVanity(publisher.getVanity());
        publisherDto.setUrl(publisher.getUrl());
        publisherDto.setLogo(publisher.getLogo());
        publisherDto.setInformation(publisher.getInformation());
        return publisherDto;
    }

    public static TitleDto titleToTitleDto(Title title, boolean isUser) {
        TitleDto titleDto = new TitleDto();
        titleDto.setId(title.getId());
        titleDto.setName(title.getName());
        titleDto.setVanity(title.getVanity());
        titleDto.setAvatar(title.getAvatar());
        titleDto.setTotalIssues(title.getTotalIssues());
        titleDto.setLaunchDate(title.getLaunchDate());
        titleDto.setPublisher(publisherToPublisherDto(title.getPublisher()));

        if(isUser) {
            titleDto.setIssues(listIssueToListIssueDto(title.getUserIssues(), isUser));
        } else {
            titleDto.setIssues(listIssueToListIssueDto(title.getIssues(), isUser));
        }

        return titleDto;
    }

    public static Set<TitleDto> listTitleToListTitleDto(Set<Title> setTitles, boolean isUser) {
        Set<TitleDto> listTitles = new TreeSet<>();
        for(Title t : setTitles) {
            listTitles.add(titleToTitleDto(t, isUser));
        }
        return listTitles;
    }

    public static IssueDto issueToIssueDto(Issue issue, boolean isUser) {
        IssueDto issueDto = new IssueDto();
        Map<String, String> staff = new HashMap<>();
        issueDto.setId(issue.getId());
        issueDto.setName(issue.getName());
        issueDto.setVanity(issue.getVanity());
        issueDto.setNumber(issue.getNumber());
        issueDto.setPrintPrice(issue.getPrintPrice());
        issueDto.setDigitalPrice(issue.getDigitalPrice());
        issueDto.setCurrency(issue.getCurrency());
        issueDto.setPublishedDate(issue.getPublishedDate());
        issueDto.setShortReview(issue.getShortReview());

        for(Role r : issue.getRoles()) {
            for(Author a : r.getAuthors()) {
                staff.put(r.getDescription(), a.getName());
            }
        }

        issueDto.setStaff(staff);

        if(isUser) {
            issueDto.setCovers(listCoverToCoverDto(issue.getUserCovers()));
        } else {
            issueDto.setCovers(listCoverToCoverDto(issue.getCovers()));
        }

//		if(issue.getTitle() != null) {
//			issueDto.setTitle(titleToTitleDto(issue.getTitle(), isUser));
//		}

        return issueDto;
    }

    public static Set<IssueDto> listIssueToListIssueDto(Set<Issue> issues, boolean isUser) {
        Set<IssueDto> listIssueDto = new TreeSet<>();
        for(Issue i : issues) {
            listIssueDto.add(issueToIssueDto(i, isUser));
        }
        return listIssueDto;
    }

    public static CoverDto coverToCoverDto(Cover cover) {
        CoverDto coverDto = new CoverDto();
        coverDto.setId(cover.getId());
        coverDto.setCoverImageUrl(cover.getCoverImageUrl());
        return coverDto;
    }

    public static Set<CoverDto> listCoverToCoverDto(Set<Cover> covers) {
        Set<CoverDto> listCoverDto = new TreeSet<>();
        for(Cover c : covers) {
            listCoverDto.add(coverToCoverDto(c));
        }
        return listCoverDto;
    }
}

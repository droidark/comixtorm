package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.*;
import com.comixtorm.collector.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ConverterService {
    //  AUTHOR CONVERTERS
    default AuthorDto toAuthorDto(Author author, boolean rqdIssues) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setAvatar(author.getAvatar());
        authorDto.setBiography(author.getBiography());
        return authorDto;
    }

    default Author toAuthor(AuthorDto authorDto, boolean rqdIssues) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setAvatar(authorDto.getAvatar());
        author.setBiography(author.getBiography());
        return author;
    }

    // PUBLISHER CONVERTERS
    default PublisherDto toPublisherDto(Publisher publisher, boolean createTitleList, boolean rqdPublisher,
                                        boolean rqdTitles, boolean rqdIssues, boolean rqdCovers) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(publisher.getId());
        publisherDto.setName(publisher.getName());
        publisherDto.setVanity(publisher.getVanity());
        publisherDto.setUrl(publisher.getUrl());
        publisherDto.setLogo(publisher.getLogo());
        publisherDto.setInformation(publisher.getInformation());
        publisherDto.setTitles(createTitleList ? toTitleDtoList(publisher.getTitles(), rqdPublisher, rqdTitles,
                rqdIssues, rqdCovers) : null);
        return publisherDto;
    }

    default Publisher toPublisher(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setId(publisherDto.getId());
        publisher.setName(publisherDto.getName());
        publisher.setVanity(publisherDto.getVanity());
        publisher.setUrl(publisherDto.getUrl());
        publisher.setLogo(publisherDto.getLogo());
        publisher.setInformation(publisherDto.getInformation());
        return publisher;
    }

    // TITLE CONVERTERS
    default TitleDto toTitleDto(Title title, boolean createPublisher, boolean rqdPublisher, boolean rqdTitles,
                                boolean rqdIssues, boolean rqdCovers) {
        TitleDto titleDto = new TitleDto();
        titleDto.setId(title.getId());
        titleDto.setName(title.getName());
        titleDto.setVanity(title.getVanity());
        titleDto.setAvatar(title.getAvatar());
        titleDto.setTotalIssues(title.getTotalIssues());
        titleDto.setLaunchDate(title.getLaunchDate());
        titleDto.setPublisher(createPublisher ? toPublisherDto(title.getPublisher(), false, rqdPublisher,
                rqdTitles, rqdIssues, rqdCovers) : null);
        titleDto.setIssues(rqdIssues ? toIssueDtoList(title.getIssues(), rqdCovers) : null);
        return titleDto;
    }

    default List<TitleDto> toTitleDtoList(Set<Title> titles, boolean rqdPublisher, boolean rqdTitles, boolean rqdIssues, boolean rqdCovers) {
        List<TitleDto> titleDtoList = new ArrayList<>();
        for(Title title : titles) {
            titleDtoList.add(toTitleDto(title, rqdPublisher, rqdTitles, rqdIssues, rqdCovers));
        }
        return titleDtoList;
    }

    // ISSUE CONVERTERS
    default IssueDto toIssueDto(Issue issue, boolean rqdCovers) {
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
        issueDto.setCovers(rqdCovers ? toCoverDtoList(issue.getCovers()) : null);
        return issueDto;
    }

    default List<IssueDto> toIssueDtoList(Set<Issue> issues, boolean rqdCovers) {
        List<IssueDto> issueDtoList = new ArrayList<>();
        for(Issue issue : issues) {
            issueDtoList.add(toIssueDto(issue, rqdCovers));
        }
        return issueDtoList;
    }

    // COVER CONVERTERS
    default CoverDto toCoverDto(Cover cover) {
        CoverDto coverDto = new CoverDto();
        coverDto.setId(cover.getId());
        coverDto.setCoverImageUrl(cover.getCoverImageUrl());
        return coverDto;
    }

    default List<CoverDto> toCoverDtoList(Set<Cover> covers) {
        List<CoverDto> coverDtoList = new ArrayList<>();
        for(Cover cover : covers) {
            coverDtoList.add(toCoverDto(cover));
        }
        return coverDtoList;
    }
    UserDto toUserDto(User user);
}

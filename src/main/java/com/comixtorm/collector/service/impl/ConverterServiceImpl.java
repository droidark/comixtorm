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
        userDto.setPublishers(new ArrayList<>());

        PublisherDto publisherDto;
        TitleDto titleDto;
        IssueDto issueDto;
        CoverDto coverDto;

        //  GET COLLECTION
        for(UserPublisherTitleIssueCover userPublisherTitleIssueCover : user.getUserPublisherTitleIssueCovers()) {
            //  PUBLISHER
            publisherDto = toPublisherDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getPublisher());
            publisherDto.setTitles(new ArrayList<>());
            if(!userDto.getPublishers().contains(publisherDto)) {
                userDto.getPublishers().add(publisherDto);
            }

            //  ISSUE
            issueDto = toIssueDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getIssue(), true);

            //  COVER
            coverDto = toCoverDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getCover());

            //  TITLE
            titleDto = toTitleDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getTitle());
            if(userDto.getPublishers().contains(titleDto.getPublisher())) {
                publisherDto = titleDto.getPublisher();
                titleDto.setPublisher(null);
                if(!userDto.getPublishers().get(userDto.getPublishers().indexOf(publisherDto)).getTitles().contains(titleDto)) {
                    userDto.getPublishers().get(userDto.getPublishers().indexOf(publisherDto)).getTitles().add(titleDto);
                }
                int x = (userDto.getPublishers().get(userDto.getPublishers().indexOf(publisherDto)).getTitles().size()) - 1;
                int y = userDto
                        .getPublishers()
                        .get(userDto.getPublishers().indexOf(publisherDto))
                        .getTitles()
                        .get(x)
                        .getIssues()
                        .indexOf(issueDto);
                int z = userDto.getPublishers().get(userDto.getPublishers().indexOf(publisherDto))
                        .getTitles().get(x).getIssues().get(y).getCovers().indexOf(coverDto);

                userDto
                        .getPublishers()
                        .get(userDto.getPublishers().indexOf(publisherDto))
                        .getTitles()
                        .get(x)
                        .getIssues().get(y).setCollected(true);

                if(z > -1) {
                    userDto
                            .getPublishers()
                            .get(userDto.getPublishers().indexOf(publisherDto))
                            .getTitles()
                            .get(x)
                            .getIssues().get(y).getCovers().get(z).setCollected(true);
                }
            }
        }
        return userDto;
    }
}

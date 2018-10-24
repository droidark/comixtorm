package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.dto.CoverDto;
import com.comixtorm.collector.dto.IssueDto;
import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.repository.UserPublisherTitleIssueCoverRepository;
import com.comixtorm.collector.service.ConverterService;
import com.comixtorm.collector.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.HashSet;

@Service("utilService")
public class UtilServiceImpl implements UtilService {

    private UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK = new UserPublisherTitleIssueCoverPK();
    private Set<UserPublisherTitleIssueCoverPK> userPublisherTitleIssueCoverPKSet = new HashSet<>();
    private TitleDto titleDto;
    private IssueDto issueDto;
    private CoverDto coverDto;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private UserPublisherTitleIssueCoverRepository userPublisherTitleIssueCoverRepository;

    @Override
    public TitleDto joinCollection(User user, Title title) {
        titleDto = converterService.toTitleDto(title, true, false, true);
        Set<UserPublisherTitleIssueCover> uptic = userPublisherTitleIssueCoverRepository.findAllByUserPublisherTitleIssueCoverPKIn(buildPK(user, title));
        int issueIndex = 0, coverIndex = 0;
        for(UserPublisherTitleIssueCover userPublisherTitleIssueCover : uptic) {
            issueDto = converterService.toIssueDto(
                    userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getIssue(),false, false, false, false, false);
            if(titleDto.getIssues().contains(issueDto)) {
                issueIndex = titleDto.getIssues().indexOf(issueDto);
                titleDto.getIssues().get(issueIndex).setCollected(true);
                for(CoverDto coverDto : titleDto.getIssues().get(issueIndex).getCovers()) {
                    this.coverDto = converterService.toCoverDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getCover(), false, false);
                    if(titleDto.getIssues().get(issueIndex).getCovers().contains(this.coverDto)) {
                        coverIndex = titleDto.getIssues().get(issueIndex).getCovers().indexOf(this.coverDto);
                        titleDto.getIssues().get(issueIndex).getCovers().get(coverIndex).setCollected(true);
                    }
                }
            }
        }
        return titleDto;
    }

    @Override
    public IssueDto joinCollection(User user, Issue issue) {
        issueDto = converterService.toIssueDto(issue, true, true, true, true, false);
        Set<UserPublisherTitleIssueCover> uptic = userPublisherTitleIssueCoverRepository.findAllByUserPublisherTitleIssueCoverPKIn(buildPK(user, issue));
        for(UserPublisherTitleIssueCover userPublisherTitleIssueCover : uptic) {
            coverDto = converterService.toCoverDto(userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getCover(), false, false);
            if(issueDto.getCovers().contains(coverDto)) {
                issueDto.setCollected(true);
                issueDto.getCovers().get(issueDto.getCovers().indexOf(coverDto)).setCollected(true);
            }
        }
        return issueDto;
    }

    private Set<UserPublisherTitleIssueCoverPK> buildPK(User user, Publisher publisher) {
        clearPKSet();
        return null;
    }

    private Set<UserPublisherTitleIssueCoverPK> buildPK(User user, Title title) {
        Set<UserPublisherTitleIssueCoverPK> userPublisherTitleIssueCoverPKSet = new HashSet<>();
        for(Issue issue : title.getIssues()) {
            for(Cover cover : issue.getCovers()) {
                UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK = new UserPublisherTitleIssueCoverPK();
                userPublisherTitleIssueCoverPK.setUser(user);
                userPublisherTitleIssueCoverPK.setPublisher(title.getPublisher());
                userPublisherTitleIssueCoverPK.setTitle(title);
                userPublisherTitleIssueCoverPK.setIssue(issue);
                userPublisherTitleIssueCoverPK.setCover(cover);
                userPublisherTitleIssueCoverPKSet.add(userPublisherTitleIssueCoverPK);
            }
        }
        return userPublisherTitleIssueCoverPKSet;
    }

    private Set<UserPublisherTitleIssueCoverPK> buildPK(User user, Issue issue) {
        Set<UserPublisherTitleIssueCoverPK> userPublisherTitleIssueCoverPKSet = new HashSet<>();
        for(Cover cover : issue.getCovers()) {
            UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK = new UserPublisherTitleIssueCoverPK();
            userPublisherTitleIssueCoverPK.setUser(user);
            userPublisherTitleIssueCoverPK.setPublisher(issue.getTitle().getPublisher());
            userPublisherTitleIssueCoverPK.setTitle(issue.getTitle());
            userPublisherTitleIssueCoverPK.setIssue(issue);
            userPublisherTitleIssueCoverPK.setCover(cover);
            userPublisherTitleIssueCoverPKSet.add(userPublisherTitleIssueCoverPK);
        }
        return userPublisherTitleIssueCoverPKSet;
    }

    private void clearPK() {
        userPublisherTitleIssueCoverPK.setUser(null);
        userPublisherTitleIssueCoverPK.setPublisher(null);
        userPublisherTitleIssueCoverPK.setTitle(null);
        userPublisherTitleIssueCoverPK.setIssue(null);
        userPublisherTitleIssueCoverPK.setCover(null);
    }

    private void clearPKSet() {
        userPublisherTitleIssueCoverPKSet.clear();
    }
}

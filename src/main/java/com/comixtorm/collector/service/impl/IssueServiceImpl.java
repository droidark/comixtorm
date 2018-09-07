package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.converter.Converter;
import com.comixtorm.collector.dto.IssueDto;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.repository.IssueRepository;
import com.comixtorm.collector.repository.TitleRepository;
import com.comixtorm.collector.repository.UserPublisherTitleIssueCoverRepository;
import com.comixtorm.collector.repository.UserRepository;
import com.comixtorm.collector.service.ConverterService;
import com.comixtorm.collector.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPublisherTitleIssueCoverRepository userPublisherTitleIssueCoverRepository;

    @Override
    public List<IssueDto> findIssuesByCriterion(String criterion, String value, String username) {
        List<IssueDto> issueDtoList;
        IssueDto issueDto;
        Set<UserPublisherTitleIssueCoverPK> userPublisherTitleIssueCoverPKSet = new HashSet<>();
        UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK;

        Set<Issue> issueSet  = issueRepository.findByNameContainingIgnoreCaseOrderById(value);
        User u = userRepository.findByUsername(username);
        for(Issue i : issueSet) {
            for(Cover c : i.getCovers()) {
                userPublisherTitleIssueCoverPK = new UserPublisherTitleIssueCoverPK();
                userPublisherTitleIssueCoverPK.setUser(u);
                userPublisherTitleIssueCoverPK.setPublisher(i.getTitle().getPublisher());
                userPublisherTitleIssueCoverPK.setTitle(i.getTitle());
                userPublisherTitleIssueCoverPK.setIssue(i);
                userPublisherTitleIssueCoverPK.setCover(c);
                userPublisherTitleIssueCoverPKSet.add(userPublisherTitleIssueCoverPK);
            }
        }

        issueDtoList = converterService.toIssueDtoList(issueSet, true,true, true, true, false);

        for(UserPublisherTitleIssueCover userPublisherTitleIssueCover :
                userPublisherTitleIssueCoverRepository.findAllByUserPublisherTitleIssueCoverPKIn(
                        userPublisherTitleIssueCoverPKSet)) {
            issueDto = converterService.toIssueDto(
                    userPublisherTitleIssueCover.getUserPublisherTitleIssueCoverPK().getIssue(),
                    true,false, false, false, true);
            if(issueDtoList.contains(issueDto)) {
                int i = issueDtoList.indexOf(issueDto);
                issueDtoList.get(i).setCollected(true);
            }
        }
        return issueDtoList;
    }

}

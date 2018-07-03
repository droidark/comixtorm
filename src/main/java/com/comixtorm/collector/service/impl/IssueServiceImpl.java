package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.converter.Converter;
import com.comixtorm.collector.dto.IssueDto;
import com.comixtorm.collector.model.Issue;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.repository.IssueRepository;
import com.comixtorm.collector.repository.TitleRepository;
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

    @Override
    public Set<IssueDto> findIssuesByCriterion(String criterion, String value, String username) {
        if(criterion.equalsIgnoreCase("name")){
            //Getting issues by name
            Set<IssueDto> searchIssues = converterService.convertToSetIssueDto(issueRepository.findByNameContainingIgnoreCase(value),true, true, false, true, false);
            Set<IssueDto> userIssues = new TreeSet<>();
            Set<Title> queryTitles = new TreeSet<>();
            //Getting titles titles
            searchIssues.forEach(issueDto -> queryTitles.add(converterService.convertToTitle(issueDto.getTitle(),false, false, false, false)));
            //Getting issues per user and titles and fill userIssues
            if(userRepository.findByUsernameAndTitlesIn(username, queryTitles) != null) {
                userRepository.findByUsernameAndTitlesIn(username, queryTitles).getTitles().forEach(
                    title -> title.getUserIssues().forEach(
                            issue -> userIssues.add(converterService.convertToIssueDto(issue, true, true, false, true, true))
                    )
                );
            }
            searchIssues.forEach(issueDto -> userIssues.add(issueDto));
            return userIssues;
            //return converterService.convertToSetIssueDto(searchIssues, true, true, false, true);
        } else if(criterion.equalsIgnoreCase("event")){
            //return Converter.listIssueToListIssueDto(issueRepository.findByEventContainingIgnoreCase(value), false);
            return null;
        }
        return null;
//        return Converter.listIssueToListIssueDto(issueRepository.findByStoryArchContainingIgnoreCase(value), false);
    }
}

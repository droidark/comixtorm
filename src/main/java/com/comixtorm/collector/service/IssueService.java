package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.IssueDto;

import java.util.List;

public interface IssueService {
    List<IssueDto> findIssuesByCriterion(String criterion, String value, String username);
    IssueDto findIssueByVanityAndTitle(String publisherVanity, String titleVanity, String issueVanity, String username);
}

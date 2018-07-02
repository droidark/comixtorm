package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.IssueDto;

import java.util.Set;

public interface IssueService {
    Set<IssueDto>findIssuesByCriterion(String criterion, String value, String username);
}

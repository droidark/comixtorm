package com.comixtorm.collector.controller;

import com.comixtorm.collector.dto.IssueDto;
import com.comixtorm.collector.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @GetMapping("/search/{criterion}/{name}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<IssueDto> findIssuesByCriterion(@PathVariable("criterion") String criterion, @PathVariable("name") String value) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return issueService.findIssuesByCriterion(criterion, value, authentication.getName());
    }

    @GetMapping("search/{publisherVanity}/{titleVanity}/{issueVanity}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public IssueDto findIssueByVanityAndTitle(@PathVariable("publisherVanity") String publisherVanity,
                                               @PathVariable("titleVanity") String titleVanity,
                                               @PathVariable("issueVanity") String issueVanity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return issueService.findIssueByVanityAndTitle(publisherVanity, titleVanity, issueVanity, authentication.getName());
    }
}

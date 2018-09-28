package com.comixtorm.collector.controller;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("search/{publisherVanity}/{titleVanity}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public TitleDto getTitle(@PathVariable("publisherVanity") String publisherVanity,
                             @PathVariable("titleVanity") String titleVanity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return titleService.findByVanityAndPublisher(authentication.getName(), titleVanity, publisherVanity);
    }
}

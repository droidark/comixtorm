package com.comixtorm.collector.controller;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.repository.UserPublisherTitleIssueCoverRepository;
import com.comixtorm.collector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPublisherTitleIssueCoverRepository userPublisherTitleIssueCoverRepository;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserDto userDto) throws Exception {
        userService.save(userDto);
    }

    @GetMapping("/titles")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public Set<TitleDto> userTitles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findTitlesByUsername(authentication.getName());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public void saveCollection(@RequestBody TitleDto titleDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.saveCollection(titleDto, authentication.getName());
    }

    @GetMapping("/something")
    public void something() {
        User u = userService.findByUsername("fozz");
        for(UserPublisherTitleIssueCover p : u.getUserPublisherTitleIssueCovers()){
            System.out.println(p.getUserPublisherTitleIssueCoverPK().getIssue().getName());
        }
        u = new User();
        u.setId(1L);
        Publisher p = new Publisher();
        p.setId(4L);
        Title t = new Title();
        t.setId(1L);
        Issue i = new Issue();
        i.setId(3L);
        Cover c = new Cover();
        c.setId(3L);
        UserPublisherTitleIssueCoverPK uk = new UserPublisherTitleIssueCoverPK();
        UserPublisherTitleIssueCover up = new UserPublisherTitleIssueCover();
        uk.setUser(u);
        uk.setPublisher(p);
        uk.setTitle(t);
        uk.setIssue(i);
        uk.setCover(c);
        up.setUserPublisherTitleIssueCoverPK(uk);
        userPublisherTitleIssueCoverRepository.save(up);
    }
}

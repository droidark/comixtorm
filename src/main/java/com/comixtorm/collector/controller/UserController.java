package com.comixtorm.collector.controller;

import com.comixtorm.collector.dto.PublisherDto;
import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.repository.UserPublisherTitleIssueCoverRepository;
import com.comixtorm.collector.service.ConverterService;
import com.comixtorm.collector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPublisherTitleIssueCoverRepository userPublisherTitleIssueCoverRepository;

    @Autowired
    private ConverterService converterService;

    @PostMapping("/register")
    public void signUp(@RequestBody UserDto userDto) throws Exception {
        userService.save(userDto);
    }

    @GetMapping("/titles")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<PublisherDto> userTitles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findPublishersByUsername(authentication.getName());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public void saveItemInCollection(@RequestBody PublisherDto publisherDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.saveOrDeleteItemInCollection(publisherDto, authentication.getName(), true);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public void deleteItemInCollection(@RequestBody PublisherDto publisherDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.saveOrDeleteItemInCollection(publisherDto, authentication.getName(), false);
    }

//    @GetMapping("/something")
//    public UserDto something() {
//        User u = userService.findByUsername("fozz");
//        return converterService.toUserDto(u);
//
//
//    }
}

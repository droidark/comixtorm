package com.comixtorm.collector.controller;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
}

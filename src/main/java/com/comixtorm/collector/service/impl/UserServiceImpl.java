package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.exception.UserAlreadyExistException;
import com.comixtorm.collector.model.Cover;
import com.comixtorm.collector.model.Issue;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.repository.UserRepository;
import com.comixtorm.collector.service.ConverterService;
import com.comixtorm.collector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(UserDto userDto) throws UserAlreadyExistException {
//        User user = userRepository.findByUsername(userDto.getUsername());
//        if (user == null) {
//            userDto.setSignUpDate(new Date());
//            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//            userDto.setStatus("PENDING");
//            userRepository.save(converterService.convertToUser(userDto, true, false, false, false));
//        } else {
//            throw new UserAlreadyExistException("User already exist!");
//        }
    }

    @Override
    public Set<TitleDto> findTitlesByUsername(String username) {
//        return converterService.convertToSetTitleDto(userRepository.findByUsername(username).getTitles(), false, true, false, false, true);
        return null;
    }

    @Override
    public void saveCollection(TitleDto titleDto, String username) {
//        Title title = new Title();
//        Issue issue = new Issue();
//        Cover cover = new Cover();
//        Set<Issue> issues = new TreeSet<>();
//        Set<Cover> covers = new TreeSet<>();
//
//        cover.setId(3L);
//        covers.add(cover);
//
//        issue.setId(74L);
//        issue.setUserCovers(covers);
//        issues.add(issue);
//
//        title.setId(13L);
//        title.setUserIssues(issues);
//        User u = userRepository.findByUsername(username);
//        u.getTitles().add(title);
//        userRepository.save(u);
    }
}

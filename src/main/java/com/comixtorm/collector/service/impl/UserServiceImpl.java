package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.dto.PublisherDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.exception.UserAlreadyExistException;
import com.comixtorm.collector.model.*;
import com.comixtorm.collector.repository.ProfileRepository;
import com.comixtorm.collector.repository.UserPublisherTitleIssueCoverRepository;
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
    private UserPublisherTitleIssueCoverRepository userPublisherTitleIssueCoverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(UserDto userDto) throws UserAlreadyExistException {
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null) {
            user = userRepository.findByEmail(userDto.getEmail());
            if(user == null) {
                userDto.setSignUpDate(new Date());
                userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userDto.setStatus("PENDING");
                User u = converterService.toUser(userDto);
                Set<Profile> profiles = new TreeSet();
                Profile p = profileRepository.findProfileById(2L);
                profiles.add(p);
                u.setProfiles(profiles);
                userRepository.save(u);
            }
            else {
                throw new UserAlreadyExistException("Email already exist!");
            }
        } else {
            throw new UserAlreadyExistException("User already exist!");
        }
    }

    @Override
    public List<PublisherDto> findPublishersByUsername(String username) {
        return converterService.toUserDto(userRepository.findByUsername(username)).getPublishers();
    }

    @Override
    public void saveOrDeleteItemInCollection(PublisherDto publisherDto, String username, boolean add) {
        User u = userRepository.findByUsername(username);

        Publisher p = new Publisher();
        p.setId(publisherDto.getId());
        Title t = new Title();
        t.setId(publisherDto.getTitles().get(0).getId());
        Issue i = new Issue();
        i.setId(publisherDto.getTitles().get(0).getIssues().get(0).getId());
        Cover c = new Cover();
        c.setId(publisherDto.getTitles().get(0).getIssues().get(0).getCovers().get(0).getId());
        UserPublisherTitleIssueCoverPK uk = new UserPublisherTitleIssueCoverPK();
        UserPublisherTitleIssueCover up = new UserPublisherTitleIssueCover();
        uk.setUser(u);
        uk.setPublisher(p);
        uk.setTitle(t);
        uk.setIssue(i);
        uk.setCover(c);
        up.setUserPublisherTitleIssueCoverPK(uk);

        if(add) {
            userPublisherTitleIssueCoverRepository.save(up);
        } else {
            userPublisherTitleIssueCoverRepository.delete(up);
        }
    }
}

package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.converter.Converter;
import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.exception.UserAlreadyExistException;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.repository.UserRepository;
import com.comixtorm.collector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto findByUsername(String username) {
        return Converter.userToUserDto(userRepository.findByUsername(username));
    }

    @Override
    public void save(UserDto userDto) throws UserAlreadyExistException {
        User user = userRepository.findByUsername(userDto.getUsername());

        if (user == null) {
            userDto.setSignUpDate(new Date());
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userDto.setStatus("PENDING");
            userRepository.save(Converter.userDtoToUser(userDto));
        } else {
            throw new UserAlreadyExistException("User already exist!");
        }
    }

    @Override
    public Set<TitleDto> findTitlesByUsername(String username) {
        Set<TitleDto> titles = new TreeSet<>();
        for(Title t : userRepository.findByUsername(username).getTitles()){
            titles.add(Converter.titleToTitleDto(t, true));
        }
        return titles;
    }
}

package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;

import java.util.Set;

public interface UserService {
//    UserDto findByUsername(String username);
    void save(UserDto userDto) throws Exception;
    Set<TitleDto> findTitlesByUsername(String username);
    void saveCollection(TitleDto titleDto, String username);
    User findByUsername(String username);
}

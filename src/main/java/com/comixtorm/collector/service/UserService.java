package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;

import java.util.Set;

public interface UserService {
    UserDto findByUsername(String username);
    void save(UserDto userDto) throws Exception;
    Set<TitleDto> findTitlesByUsername(String username);
}

package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.UserDto;

public interface UserService {
    UserDto findByUsername(String username);
    void save(UserDto userDto) throws Exception;
}

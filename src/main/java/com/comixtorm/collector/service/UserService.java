package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.PublisherDto;
import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.dto.UserDto;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
//    UserDto findByUsername(String username);
    void save(UserDto userDto) throws Exception;
    List<PublisherDto> findPublishersByUsername(String username);
    void saveOrDeleteItemInCollection(PublisherDto publisherDto, String username, boolean add);
    User findByUsername(String username);
}

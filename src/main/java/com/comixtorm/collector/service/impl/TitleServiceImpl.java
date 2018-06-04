package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.converter.Converter;
import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.repository.TitleRepository;
import com.comixtorm.collector.repository.UserRepository;
import com.comixtorm.collector.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("titleService")
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TitleDto findByVanityOrderByIdAsc(String vanity) {
        return Converter.titleToTitleDto(titleRepository.findByVanityOrderByIdAsc(vanity), false);
    }

    @Override
    public TitleDto findByVanityAndUsersIn(String vanity, String username) {
        Set<User> users = Stream.of(userRepository.findByUsername(username)).collect(Collectors.toSet());
        return Converter.titleToTitleDto(titleRepository.findByVanityAndUsersIn(vanity, users), true);
    }
}

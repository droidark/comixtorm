package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.model.Publisher;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.repository.PublisherRepository;
import com.comixtorm.collector.repository.TitleRepository;
import com.comixtorm.collector.repository.UserRepository;
import com.comixtorm.collector.service.ConverterService;
import com.comixtorm.collector.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("titleService")
public class TitleServiceImpl implements TitleService {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TitleDto findByVanityOrderByIdAsc(String vanity) {
//        return converterService.convertToTitleDto(titleRepository.findByVanityOrderByIdAsc(vanity),true, false, false, false, false);
        return null;
    }

    @Override
    public TitleDto findByVanityAndUsersIn(String vanity, String username) {
//        Set<User> users = Stream.of(userRepository.findByUsername(username)).collect(Collectors.toSet());
//        return converterService.convertToTitleDto(titleRepository.findByVanityAndUsersIn(vanity, users),false, true, false, false, false);
        return null;
    }

    @Override
    public TitleDto findByVanityAndPublisher(String titleVanity, String publisherVanity) {
        return converterService.toTitleDto(
                titleRepository.findByVanityAndPublisher(titleVanity, publisherRepository.findByVanity(publisherVanity)),
                true, false, true);
    }
}

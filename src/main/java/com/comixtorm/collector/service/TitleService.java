package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.model.Issue;
import com.comixtorm.collector.model.Publisher;
import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;

import java.util.Set;

public interface TitleService {
    TitleDto findByVanityOrderByIdAsc(String vanity);
    TitleDto findByVanityAndUsersIn(String vanity, String username);
    TitleDto findByVanityAndPublisher(String username, String titleVanity, String publisherVanity);
}

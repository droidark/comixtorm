package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.TitleDto;

public interface TitleService {
    TitleDto findByVanityOrderByIdAsc(String vanity);
    TitleDto findByVanityAndUsersIn(String vanity, String username);
}

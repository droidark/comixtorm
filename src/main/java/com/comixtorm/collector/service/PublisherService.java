package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.PublisherDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PublisherService {

    Page<PublisherDTO> getPublishers(Pageable pageable);
}

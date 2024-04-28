package com.comixtorm.collector.service.impl;

import com.comixtorm.collector.domain.repository.PublisherRepository;
import com.comixtorm.collector.dto.PublisherDTO;
import com.comixtorm.collector.service.PublisherService;
import com.comixtorm.collector.util.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    private final MapperService mapper;


    @Override
    public Page<PublisherDTO> getPublishers(Pageable pageable) {
        return publisherRepository.findAll(pageable).map(mapper::toPublisherDTO);
    }
}

package com.comixtorm.collector.controller.impl;

import com.comixtorm.collector.controller.PublisherController;
import com.comixtorm.collector.dto.PublisherDTO;
import com.comixtorm.collector.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.comixtorm.collector.util.Utilities.buildSortCriteria;

@RestController
@RequiredArgsConstructor
public class PublisherControllerImpl implements PublisherController {

    private final PublisherService publisherService;

    @Override
    public ResponseEntity<Page<PublisherDTO>> getAllPublishers(int page, int size, String[] sort) {
        Page<PublisherDTO> publisherDTOPage = publisherService.getPublishers(PageRequest.of(page, size, buildSortCriteria(sort)));
        if (!publisherDTOPage.isEmpty()) {
            return ResponseEntity.ok(publisherDTOPage);
        }
        return ResponseEntity.noContent().build();
    }
}

package com.comixtorm.collector.service;

import com.comixtorm.collector.domain.model.Publisher;
import com.comixtorm.collector.domain.repository.PublisherRepository;
import com.comixtorm.collector.service.impl.PublisherServiceImpl;
import com.comixtorm.collector.util.MapperService;
import com.comixtorm.collector.util.TestUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PublisherServiceTest {

    @Mock
    private PublisherRepository publisherRepository;

    @Mock
    private MapperService mapperService;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    @Test
    @DisplayName("Should return all publishers")
    void should_return_all_publishers() {
        // Given
        var expected = 1;
        var pageNumber = 0;
        var pageSize = 10;
        var pagination = PageRequest.of(pageNumber, pageSize);

        // When
        when(publisherRepository.findAll(pagination)).thenReturn(new PageImpl<>(TestUtilities.buildPublishers()));
        when(mapperService.toPublisherDTO(any(Publisher.class))).thenReturn(TestUtilities.buildPublisherDTO());
        var result = publisherService.getPublishers(PageRequest.of(0, 10));

        // Then
        assertEquals(expected, result.getTotalElements());
    }
}
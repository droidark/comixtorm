package com.comixtorm.collector.domain.repository;

import com.comixtorm.collector.util.TestUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository repository;

    @Test
    @DisplayName("Should return all publishers")
    void should_return_all_publishers() {
        // Given
        var expected = 5;
        var pageNumber = 0;
        var pageSize = 10;
        var pagination = PageRequest.of(pageNumber, pageSize);

        // When
        var publishers = repository.findAll(pagination);

        // Then
        assertEquals(expected, publishers.getTotalElements());
    }

    @Test
    @DisplayName("Should add publisher")
    void should_add_publisher() {
        // Given
        var publisher = TestUtilities.buildPublisher();

        // When
        var savedPublisher = repository.save(publisher);

        // Then
        assertEquals(publisher, savedPublisher);
    }

    @Test
    @DisplayName("Should remove publisher")
    void should_remove_publisher() {
        // Given
        var id = 1L;
        var publisher = repository.findById(id);

        // When
        repository.delete(publisher.orElseThrow());

        // Then
        assertFalse(repository.findById(id).isPresent());
    }
}
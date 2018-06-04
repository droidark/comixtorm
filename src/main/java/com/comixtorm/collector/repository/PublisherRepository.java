package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Publisher findByVanity(String vanity);
}

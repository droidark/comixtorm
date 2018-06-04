package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}

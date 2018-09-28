package com.comixtorm.collector.repository;

import com.comixtorm.collector.model.Title;
import com.comixtorm.collector.model.User;
import com.comixtorm.collector.model.UserPublisherTitleIssueCover;
import com.comixtorm.collector.model.UserPublisherTitleIssueCoverPK;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserPublisherTitleIssueCoverRepository extends CrudRepository<UserPublisherTitleIssueCover, UserPublisherTitleIssueCoverPK> {
    Set<UserPublisherTitleIssueCover> findAllByUserPublisherTitleIssueCoverPKIn(
            Set<UserPublisherTitleIssueCoverPK> userPublisherTitleIssueCoverPKSet);
    Set<UserPublisherTitleIssueCover> findAllByUserPublisherTitleIssueCoverPK(UserPublisherTitleIssueCoverPK userPublisherTitleIssueCoverPK);
}

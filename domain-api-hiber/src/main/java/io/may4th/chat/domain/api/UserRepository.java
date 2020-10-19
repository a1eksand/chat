package io.may4th.chat.domain.api;

import io.may4th.chat.domain.api.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID>, QueryByExampleExecutor<User> {

    Optional<User> findByUsername(String username);
}

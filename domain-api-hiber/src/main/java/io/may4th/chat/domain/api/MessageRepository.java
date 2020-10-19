package io.may4th.chat.domain.api;

import io.may4th.chat.domain.api.entities.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends PagingAndSortingRepository<Message, UUID>, QueryByExampleExecutor<Message> {

    List<Message> findAllByRoomIdOrderByTimestamp(UUID roomId);
}

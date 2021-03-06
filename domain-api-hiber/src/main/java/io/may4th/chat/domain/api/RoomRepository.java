package io.may4th.chat.domain.api;

import io.may4th.chat.domain.api.entities.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface RoomRepository extends PagingAndSortingRepository<Room, UUID>, QueryByExampleExecutor<Room> {
}

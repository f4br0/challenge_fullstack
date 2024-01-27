package com.reto.infrastructure.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ItemRepository extends R2dbcRepository<ItemData, Long> {
    Flux<ItemData> findByNameContainingIgnoreCase(String name);


}

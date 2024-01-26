package com.reto.infrastructure.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


public interface ItemRepository extends R2dbcRepository<ItemData, Long> {
    Flux<ItemData> findByNameContainingIgnoreCase(String name);


}

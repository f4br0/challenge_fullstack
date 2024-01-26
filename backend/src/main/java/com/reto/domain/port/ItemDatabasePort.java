package com.reto.domain.port;

import com.reto.domain.model.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemDatabasePort {
    Flux<Item> searchItemContainsLimit(String name, Integer limit);
    Mono<Item> findItem(Long id);
}

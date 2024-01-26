package com.reto.infrastructure.adapter;

import com.reto.application.dto.exception.BusinessException;
import com.reto.application.service.ItemMapper;
import com.reto.domain.model.Item;
import com.reto.domain.port.ItemDatabasePort;
import com.reto.infrastructure.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemDatabasePort {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public Flux<Item> searchItemContainsLimit(String name, Integer limit) {
        return itemRepository.findByNameContainingIgnoreCase(name).take(limit)
                .map(itemMapper::apply);
    }

    @Override
    public Mono<Item> findItem(Long id) {
        return itemRepository.findById(id)
                .switchIfEmpty(Mono.error(new BusinessException(HttpStatus.NOT_FOUND, "Item not found")))
                .map(itemMapper::apply);
    }
}

package com.reto.domain.usecase;

import com.reto.domain.model.Item;
import com.reto.domain.port.ItemDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindItemUseCase {
    private final ItemDatabasePort itemDatabasePort;

    public Mono<Item> execute(Long id) {
        return itemDatabasePort.findItem(id);
    }

}

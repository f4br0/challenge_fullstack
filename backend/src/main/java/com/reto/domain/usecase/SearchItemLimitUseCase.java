package com.reto.domain.usecase;

import com.reto.domain.model.Item;
import com.reto.domain.port.ItemDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class SearchItemLimitUseCase{
    private final ItemDatabasePort itemDatabasePort;

    public Flux<Item> execute(String search, Integer limit) {
        return itemDatabasePort.searchItemContainsLimit(search, limit);
    }

}

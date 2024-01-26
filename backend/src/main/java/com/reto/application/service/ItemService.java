package com.reto.application.service;

import com.reto.application.dto.ItemDetailResponse;
import com.reto.application.dto.ItemResponse;
import com.reto.domain.usecase.FindItemUseCase;
import com.reto.domain.usecase.SearchItemLimitUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ItemService {

    private final SearchItemLimitUseCase searchItemLimitUseCase;
    private final FindItemUseCase findItemUseCase;

    public Flux<ItemResponse> searchItem(String search, Integer limit) {
        return searchItemLimitUseCase.execute(search, limit)
                .map(item -> new ItemResponse(item.getId(), item.getName()));
    }

    public Mono<ItemDetailResponse> findById(Long id) {
        return findItemUseCase.execute(id)
                .map(item -> new ItemDetailResponse(item.getId(), item.getName(), item.getDescription()));
    }
}

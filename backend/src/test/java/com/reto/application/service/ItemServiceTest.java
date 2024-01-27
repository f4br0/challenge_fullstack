package com.reto.application.service;

import com.reto.application.dto.ItemDetailResponse;
import com.reto.application.dto.ItemResponse;
import com.reto.domain.model.Item;
import com.reto.domain.usecase.FindItemUseCase;
import com.reto.domain.usecase.SearchItemLimitUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private SearchItemLimitUseCase searchItemLimitUseCase;

    @Mock
    private FindItemUseCase findItemUseCase;

    @InjectMocks
    private ItemService itemService;

    @Test
    void testSearchItem() {
        Item item = new Item(1L, "Item1", "");
        when(searchItemLimitUseCase.execute(any(String.class), anyInt()))
                .thenReturn(Flux.just(item));

        Flux<ItemResponse> result = itemService.searchItem("test", 10);

        StepVerifier.create(result)
                .expectNext(new ItemResponse(item.getId(), item.getName()))
                .verifyComplete();
    }

    @Test
    void testFindById() {
        Item item = new Item(1L, "Item1", "Description");
        when(findItemUseCase.execute(anyLong()))
                .thenReturn(Mono.just(item));

        Mono<ItemDetailResponse> result = itemService.findById(1L);

        StepVerifier.create(result)
                .expectNext(new ItemDetailResponse(item.getId(), item.getName(), item.getDescription()))
                .verifyComplete();
    }
}
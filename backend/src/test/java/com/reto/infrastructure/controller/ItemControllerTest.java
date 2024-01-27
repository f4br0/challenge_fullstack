package com.reto.infrastructure.controller;

import com.reto.application.dto.ItemDetailResponse;
import com.reto.application.dto.ItemResponse;
import com.reto.application.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

class ItemControllerTest {
    private final ItemService itemService = Mockito.mock(ItemService.class);
    private final ItemController itemController = new ItemController(itemService);

    @Test
    void testSearchItem() {
        ItemResponse itemResponse = new ItemResponse(1L,""); // Set up your ItemResponse
        Mockito.when(itemService.searchItem(any(String.class), any(Integer.class)))
                .thenReturn(Flux.just(itemResponse));

        Flux<ItemResponse> result = itemController.searchItem("test", 10);

        StepVerifier.create(result)
                .expectNext(itemResponse)
                .verifyComplete();
    }

    @Test
    void testGetItem() {
        ItemDetailResponse itemDetailResponse = new ItemDetailResponse(1L,"",""); // Set up your ItemDetailResponse
        Mockito.when(itemService.findById(anyLong()))
                .thenReturn(Mono.just(itemDetailResponse));

        Mono<ResponseEntity<ItemDetailResponse>> result = itemController.getItem(1L);

        StepVerifier.create(result)
                .expectNext(ResponseEntity.ok(itemDetailResponse))
                .verifyComplete();
    }
}
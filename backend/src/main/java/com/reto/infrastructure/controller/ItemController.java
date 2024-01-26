package com.reto.infrastructure.controller;

import com.reto.application.dto.ItemDetailResponse;
import com.reto.application.dto.ItemResponse;
import com.reto.application.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    @GetMapping()
    public Flux<ItemResponse> searchItem(@RequestParam String search, @RequestParam Integer limit) {
        return itemService.searchItem(search, limit);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ItemDetailResponse>> getItem(@PathVariable Long id) {
        return itemService.findById(id).map(ResponseEntity::ok);
    }
}

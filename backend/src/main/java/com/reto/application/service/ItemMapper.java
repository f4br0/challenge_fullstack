package com.reto.application.service;

import com.reto.domain.model.Item;
import com.reto.infrastructure.repository.ItemData;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ItemMapper implements Function<ItemData, Item> {

    @Override
    public Item apply(ItemData itemData) {
        return Item.builder()
                .id(itemData.getId())
                .name(itemData.getName())
                .description(itemData.getDescription())
                .build();
    }
}

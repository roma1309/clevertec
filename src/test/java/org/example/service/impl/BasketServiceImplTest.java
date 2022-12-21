package org.example.service.impl;

import org.example.model.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BasketServiceImplTest {

    @InjectMocks
    private BasketServiceImpl basketService;

    @Test
    void addBasket() {

        Set<Basket> baskets = basketService.addBasket(generateList());
        Assertions.assertNotEquals(0, baskets.size());
        Assertions.assertEquals(7,baskets.size());
    }

    private List<Long> generateList() {
        return List.of(10l, 1l, 3l, 4l, 6l, 2l, 6l, 7l, 4l, 4l, 4l, 3l, 3l, 3l);
    }
}
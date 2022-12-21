package org.example.service.impl;

import org.example.model.Basket;
import org.example.service.BasketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BasketServiceImpl implements BasketService {

    @Override
    public Set<Basket> addBasket(List<Long> itemId) {
        Set<Basket> baskets = new HashSet<>();
        for (Long id : itemId) {
            Basket basket = new Basket();
            int countProduct = (int) itemId.stream().filter(id::equals).count();
            if (countProduct > 0) {
                basket.setIdProduct(id);
                basket.setCountProduct(countProduct);
                baskets.add(basket);
            }
        }
        return baskets;
    }
}

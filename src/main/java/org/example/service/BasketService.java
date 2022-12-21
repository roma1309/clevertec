package org.example.service;

import org.example.model.Basket;

import java.util.List;
import java.util.Set;

public interface BasketService {

    Set<Basket> addBasket(List<Long> itemId);

}

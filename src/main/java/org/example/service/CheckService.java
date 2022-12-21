package org.example.service;

import org.example.model.Basket;
import org.example.model.Check;
import org.example.model.ProductInCheck;
import org.example.model.entity.Product;

import java.util.List;

public interface CheckService {
    Check getCheck(List<Long> itemsId, Long numberCard);

    ProductInCheck mappingCheck(Product product, Basket basket);

    double calculateCost(ProductInCheck productInCheck);

    double calculatingTotalCostWithDiscountCard(Long numberCard, Check check);


}

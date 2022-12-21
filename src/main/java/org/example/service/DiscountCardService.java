package org.example.service;

import org.example.model.entity.DiscountCard;

public interface DiscountCardService {

    DiscountCard findByNumberCard(Long number);
}

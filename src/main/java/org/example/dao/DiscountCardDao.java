package org.example.dao;

import org.example.model.entity.DiscountCard;

public interface DiscountCardDao {
    DiscountCard readByNumberCard(long number);
}

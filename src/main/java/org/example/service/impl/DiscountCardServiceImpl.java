package org.example.service.impl;

import org.example.dao.DiscountCardDao;
import org.example.model.entity.DiscountCard;
import org.example.service.DiscountCardService;
import org.example.web.exceptions.DiscountCardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountCardServiceImpl implements DiscountCardService {

    private final DiscountCardDao discountCardDao;

    @Autowired
    public DiscountCardServiceImpl(DiscountCardDao discountCardDao) {
        this.discountCardDao = discountCardDao;
    }

    @Override
    public DiscountCard findByNumberCard(Long number) {
        DiscountCard discountCard = discountCardDao.readByNumberCard(number);
        if (discountCard == null) {
            throw new DiscountCardNotFoundException("номер карты не был найден");
        }
        return discountCard;
    }
}

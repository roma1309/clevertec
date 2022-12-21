package org.example.service.impl;

import org.example.dao.DiscountCardDao;
import org.example.model.entity.DiscountCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DiscountCardServiceImplTest {
    @Mock
    private DiscountCardDao discountCardDao;
    @InjectMocks
    private DiscountCardServiceImpl discountCardService;

    @Test
    void findByNumberCard() {
        long id1 = 44;
        long id2 = 55;

        Mockito.when(discountCardDao.readByNumberCard(id1)).thenReturn(discountCards().get(0));
         Mockito.when(discountCardDao.readByNumberCard(id2)).thenReturn(discountCards().get(1));

        DiscountCard discountCard2 = discountCardService.findByNumberCard(id1);
        DiscountCard discountCard3 = discountCardService.findByNumberCard(id2);

        Assertions.assertEquals(44, discountCard2.getNumberCard());
        Assertions.assertEquals(55, discountCard3.getNumberCard());
    }

    private List<DiscountCard> discountCards() {
        DiscountCard discountCard1 = new DiscountCard();
        discountCard1.setNumberCard(44l);

        DiscountCard discountCard2 = new DiscountCard();
        discountCard2.setNumberCard(55l);

        return List.of(discountCard1, discountCard2);
    }
}
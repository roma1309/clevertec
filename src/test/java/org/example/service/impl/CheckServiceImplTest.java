package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.Basket;
import org.example.model.Check;
import org.example.model.ProductInCheck;
import org.example.model.entity.DiscountCard;
import org.example.model.entity.Product;
import org.example.service.BasketService;
import org.example.service.DiscountCardService;
import org.example.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckServiceImplTest {
    @Mock
    private ProductDao productDao;
    @Mock
    private BasketService basketService;
    @Mock
    private DiscountCardService discountCardService;
    @Mock
    private ProductService productService;

    @InjectMocks
    private CheckServiceImpl checkService;

    @Test
    void getCheck() {

        Mockito.when(productDao.selectProducts()).thenReturn(generateProduct());
        Mockito.when(basketService.addBasket(generateItems())).thenReturn(generateBasket());
        Check check = checkService.getCheck(generateItems(), null);
        Assertions.assertEquals(3, check.getProduct().size());
    }

    @Test
    void mappingCheck() {
        Product product = new Product();
        Basket basket = new Basket();
        basket.setCountProduct(11);
        ProductInCheck productInCheck = checkService.mappingCheck(product, basket);

        Assertions.assertEquals(11, productInCheck.getCount());
    }

    @Test
    void calculateCost() {
        ProductInCheck productInCheck = new ProductInCheck();
        productInCheck.setTotal(445);
        double cost = checkService.calculateCost(productInCheck);
        System.out.println(cost);
        Assertions.assertTrue(cost > 0);
    }

    @Test
    void calculatingTotalCostWithDiscountCard() {
        long numberCard1 = 21;
        Check check = new Check();
        Mockito.when(discountCardService.findByNumberCard(numberCard1)).thenReturn(new DiscountCard());
        double cost1 = checkService.calculatingTotalCostWithDiscountCard(numberCard1, check);
        Assertions.assertNotNull(cost1);
    }

    private List<Long> generateItems() {
        return List.of(1l, 4l, 1l, 4l, 5l, 1l, 4l, 1l);
    }

    private List<Product> generateProduct() {
        Product product1 = new Product();
        product1.setStock(true);
        product1.setId(4l);
        product1.setPrice(2);
        product1.setName("milk");
        product1.setCount(50);

        Product product2 = new Product();
        product2.setStock(true);
        product2.setId(1l);
        product2.setPrice(24);
        product2.setName("chick");
        product2.setCount(50);

        Product product3 = new Product();
        product3.setStock(false);
        product3.setId(5l);
        product3.setPrice(4);
        product3.setName("cola");
        product3.setCount(50);
        return List.of(product1, product2, product3);
    }

    private Set<Basket> generateBasket() {
        Basket basket1 = new Basket();
        basket1.setCountProduct(4);
        basket1.setIdProduct(1l);

        Basket basket2 = new Basket();
        basket2.setCountProduct(3);
        basket2.setIdProduct(4l);

        Basket basket3 = new Basket();
        basket3.setCountProduct(1);
        basket3.setIdProduct(5l);

        return Set.of(basket1, basket2, basket3);
    }

}
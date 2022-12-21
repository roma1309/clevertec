package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductDao productDao;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void getProduct() {
        List<Product> products = generateList();
        Mockito.when(productDao.selectProducts()).thenReturn(products);
        productService.getProduct();

        Assertions.assertNotNull(products);
        Assertions.assertEquals(3, products.size());
    }

    private List<Product> generateList() {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        return List.of(product1, product2, product3);
    }
}
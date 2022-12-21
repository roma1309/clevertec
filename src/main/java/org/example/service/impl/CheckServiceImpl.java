package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.Basket;
import org.example.model.Check;
import org.example.model.ProductInCheck;
import org.example.model.entity.DiscountCard;
import org.example.model.entity.Product;
import org.example.service.BasketService;
import org.example.service.CheckService;
import org.example.service.DiscountCardService;
import org.example.service.ProductService;
import org.example.web.exceptions.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CheckServiceImpl implements CheckService {
    private final ProductDao productDao;
    private final BasketService basketService;

    private final DiscountCardService discountCardService;
    private final ProductService productService;

    @Autowired
    public CheckServiceImpl(ProductDao productDao, BasketService basketService,
                            DiscountCardService discountCardService, ProductService productService) {
        this.productDao = productDao;
        this.basketService = basketService;
        this.discountCardService = discountCardService;
        this.productService = productService;
    }

    @Override
    public Check getCheck(List<Long> itemsId, Long numberCard) {
        List<Product> products = productDao.selectProducts();
        List<ProductInCheck> productInCheckList = new ArrayList<>();

        Set<Basket> baskets = basketService.addBasket(itemsId);

        for (Basket basket : baskets) {
            Product product = products.stream().filter((p) -> basket.getIdProduct() == p.getId()).findFirst().orElse(null);
            if (product != null && product.getCount() >= basket.getCountProduct()) {
                ProductInCheck productInCheck = mappingCheck(product, basket);
                if (productInCheck.isStock() && productInCheck.getCount() >= 5) {
                    productInCheck.setStock(calculateCost(productInCheck));
                    productInCheck.setTotal(productInCheck.getTotal() - productInCheck.getStock());
                }
                productInCheckList.add(productInCheck);
            } else if (product == null || product.getCount() < basket.getCountProduct()) {
                throw new ProductException("Неверный id или неверное количество товара");
            }
        }
        Check check = new Check();
        check.setProduct(productInCheckList);
        check.setTotalCost();

        if (numberCard != null) {
            check.setCost(calculatingTotalCostWithDiscountCard(numberCard, check));
        }
        productService.deleteOrUpdateProduct(check, products);
        return check;
    }

    @Override
    public ProductInCheck mappingCheck(Product product, Basket basket) {

        ProductInCheck productInCheck = new ProductInCheck();
        productInCheck.setId(product.getId());
        productInCheck.setCost(product.getPrice());
        productInCheck.setCount(basket.getCountProduct());
        productInCheck.setName(product.getName());
        productInCheck.setStock(product.isStock());
        double cost = productInCheck.getCost() * productInCheck.getCount();
        productInCheck.setTotal(cost);
        return productInCheck;
    }


    @Override
    public double calculateCost(ProductInCheck productInCheck) {
        return productInCheck.getTotal() * 0.1;
    }

    @Override
    public double calculatingTotalCostWithDiscountCard(Long numberCard, Check check) {
        DiscountCard discountCard = discountCardService.findByNumberCard(numberCard);
        double cost = check.getTotalCost() * (100 - discountCard.getStock()) / 100;
        check.setTotalStock(discountCard.getStock());
        return cost;
    }

}

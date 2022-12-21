package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.Check;
import org.example.model.ProductInCheck;
import org.example.model.entity.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        products = productDao.selectProducts();
        return products;
    }

    @Override
    public void deleteOrUpdateProduct(Check check, List<Product> products) {
        for (ProductInCheck productInCheck : check.getProduct()) {
            Product product = products.stream().filter((p) -> productInCheck.getId() == p.getId()).findFirst().orElse(null);
            if (product.getCount() == productInCheck.getCount()) {
                productDao.deleteProductById(product.getId());
            } else {
                productDao.updateProductCountById(product.getId(), product.getCount() - productInCheck.getCount());
            }
        }
    }
}

package org.example.service;

import org.example.model.Check;
import org.example.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProduct();

    void deleteOrUpdateProduct(Check check, List<Product> products);
}

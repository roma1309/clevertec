package org.example.dao;

import org.example.model.Check;
import org.example.model.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> selectProducts();
    void deleteProductById(long id);
    void updateProductCountById(long id, long count);
}

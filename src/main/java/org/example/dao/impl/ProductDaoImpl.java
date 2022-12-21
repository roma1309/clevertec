package org.example.dao.impl;

import org.example.dao.BaseDao;
import org.example.dao.ProductDao;
import org.example.dao.mapper.ProductMapper;
import org.example.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public List<Product> selectProducts() {
        final String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public void deleteProductById(long id) {
        final String sql = "DELETE FROM products WHERE id=" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public void updateProductCountById(long id, long count) {
        final String sql = String.format("UPDATE products SET count=%s WHERE id=%s", count, id);
        jdbcTemplate.update(sql);
    }
}

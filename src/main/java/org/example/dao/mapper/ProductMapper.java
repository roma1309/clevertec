package org.example.dao.mapper;

import org.example.model.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setCount(rs.getInt("count"));
        product.setPrice(rs.getDouble("price"));
        product.setStock(rs.getBoolean("isStock"));
        return product;
    }
}

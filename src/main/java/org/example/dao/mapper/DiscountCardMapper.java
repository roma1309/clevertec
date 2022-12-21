package org.example.dao.mapper;

import org.example.model.entity.DiscountCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountCardMapper implements RowMapper<DiscountCard> {
    @Override
    public DiscountCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setId(rs.getLong("id"));
        discountCard.setNumberCard(rs.getLong("numberCard"));
        discountCard.setStock(rs.getDouble("stock"));
        return discountCard;
    }
}

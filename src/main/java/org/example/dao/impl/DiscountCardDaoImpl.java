package org.example.dao.impl;

import org.example.dao.BaseDao;
import org.example.dao.DiscountCardDao;
import org.example.dao.mapper.DiscountCardMapper;
import org.example.model.entity.DiscountCard;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountCardDaoImpl extends BaseDao implements DiscountCardDao {
    @Override
    public DiscountCard readByNumberCard(long number) {
        final String sql = "SELECT * FROM discount_card WHERE numberCard=" + number;
        try {
            return jdbcTemplate.queryForObject(sql, new DiscountCardMapper());
        } catch (DataAccessException ex) {
            return null;
        }
    }
}

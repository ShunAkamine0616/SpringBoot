package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.ProductDao;
import com.example.entity.Product;

@Repository
public class PgProductDao implements ProductDao {

    private static final String SELECT_BY_USER_ID = "SELECT * FROM products WHERE product_id = :id ORDER BY product_id";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Product findById(Integer id) {
        String sql = SELECT_BY_USER_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

}


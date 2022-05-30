package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.ProductDao;
import com.example.entity.Product;

@Repository
public class PgProductDao implements ProductDao {

    private static final String SELECT_BY_PRODUCT_ID = "SELECT * FROM products WHERE product_id = :id ORDER BY product_id";
    private static final String SELECT_BY_PRODUCT_NAME = "SELECT * FROM products WHERE product_name = :name ORDER BY product_id";
    private static final String SELECT_BY_PRODUCT_PRICE = "SELECT * FROM products WHERE price = :price ORDER BY product_id";
    private static final String SELECT_BY_PRODUCT_NAME_AND_PRICE = "SELECT * FROM products WHERE product_name = :name AND price = :price  ORDER BY product_id";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM products";
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate2;
    public Product findById(Integer id) {
        String sql = SELECT_BY_PRODUCT_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public List<Product> findByName(String name) {
        String sql = SELECT_BY_PRODUCT_NAME;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList;
    }
    
    public List<Product> findByPrice(Integer price) {
        String sql = SELECT_BY_PRODUCT_PRICE;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("price", price);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList;
    }
    
    public List<Product> findByNameAndPrice(String name, Integer price) {
        String sql = SELECT_BY_PRODUCT_NAME_AND_PRICE;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);
        param.addValue("price", price);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList;
    }
    
    public List<Product> findAll() {
        String sql = SELECT_ALL_PRODUCT;
//        MapSqlParameterSource param = new MapSqlParameterSource();
        List<Product> resultList = jdbcTemplate2.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList;
    }

}


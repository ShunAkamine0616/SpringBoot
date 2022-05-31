
package com.example.dao;

import java.util.List;

import com.example.entity.Product;

public interface ProductDao {

    public Product findById(Integer id);
    public List<Product> findByName(String name);
    public List<Product> findByPrice(Integer price);
    public List<Product> findByNameAndPrice(String name, Integer price);
    public List<Product> findAll();
    public void insert(String name, Integer price);
}


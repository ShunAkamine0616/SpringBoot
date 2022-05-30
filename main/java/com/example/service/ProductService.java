package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {

    public Product findById(Integer id);
    public List<Product> findByName(String name);
    public List<Product> findByPrice(Integer price);
    public List<Product> findByNameAndPrice(String name, Integer id);
    public List<Product> findAll();
}

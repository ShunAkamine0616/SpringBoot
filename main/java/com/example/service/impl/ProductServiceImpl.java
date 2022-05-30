package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.entity.Product;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product findById(Integer id) {
        return productDao.findById(id);
    }
    public List<Product> findByName(String name) {
        return productDao.findByName(name);
    }
    public List<Product> findByPrice(Integer price) {
        return productDao.findByPrice(price);
    }
    public List<Product> findByNameAndPrice(String name, Integer price) {
        return productDao.findByNameAndPrice(name, price);
    }
    public List<Product> findAll() {
        return productDao.findAll();
    }
}


package com.hn.springbootmobilestore.service.product;

import com.hn.springbootmobilestore.entity.Product;

import java.util.*;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    Product findByProductID(int id);
}

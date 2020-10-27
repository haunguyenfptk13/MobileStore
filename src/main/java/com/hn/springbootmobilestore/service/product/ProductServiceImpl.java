package com.hn.springbootmobilestore.service.product;

import com.hn.springbootmobilestore.entity.Product;
import com.hn.springbootmobilestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByProductID(int id) {
        return productRepository.findByProductID(id);
    }
}

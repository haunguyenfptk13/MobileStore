package com.hn.springbootmobilestore.service.statusProduct;

import com.hn.springbootmobilestore.entity.StatusProduct;
import com.hn.springbootmobilestore.repository.StatusProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusProductServiceImpl implements StatusProductService{

    @Autowired
    private StatusProductRepository statusProductRepository;

    @Override
    public List<StatusProduct> findAll() {
        return statusProductRepository.findAll();
    }

    @Override
    public StatusProduct findByName(String name) {
        return statusProductRepository.findByName(name);
    }
}

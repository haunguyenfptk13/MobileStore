package com.hn.springbootmobilestore.repository;

import com.hn.springbootmobilestore.entity.StatusProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
public interface StatusProductRepository extends JpaRepository<StatusProduct, Integer>, JpaSpecificationExecutor<StatusProduct> {
    List<StatusProduct> findAll();

    StatusProduct findByName(String name);
}
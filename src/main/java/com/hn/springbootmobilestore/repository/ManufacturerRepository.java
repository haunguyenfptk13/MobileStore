package com.hn.springbootmobilestore.repository;

import com.hn.springbootmobilestore.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>, JpaSpecificationExecutor<Manufacturer> {
    List<Manufacturer> findAll();
    Manufacturer findByName(String name);
}
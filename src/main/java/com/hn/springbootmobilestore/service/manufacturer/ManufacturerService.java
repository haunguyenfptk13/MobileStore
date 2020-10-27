package com.hn.springbootmobilestore.service.manufacturer;
import com.hn.springbootmobilestore.entity.Manufacturer;

import java.util.*;

public interface ManufacturerService{
    List<Manufacturer> findAll();

    Manufacturer findByName(String name);
}

package com.hn.springbootmobilestore.service.statusProduct;
import com.hn.springbootmobilestore.entity.StatusProduct;

import java.util.*;

public interface StatusProductService {
    List<StatusProduct> findAll();
    StatusProduct findByName(String name);
}

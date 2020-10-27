package com.hn.springbootmobilestore.service.category;
import com.hn.springbootmobilestore.entity.Category;

import java.util.*;
public interface CategoryService {
    List<Category> findAll();

    Category findByName(String name);

    Category saveAndFlush(Category category);
}

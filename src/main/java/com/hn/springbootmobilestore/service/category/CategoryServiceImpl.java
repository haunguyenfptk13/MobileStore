package com.hn.springbootmobilestore.service.category;

import com.hn.springbootmobilestore.entity.Category;
import com.hn.springbootmobilestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name){
        return categoryRepository.findByName(name);
    }

    @Override
    public Category saveAndFlush(Category category) {
        return categoryRepository.saveAndFlush(category);
    }
}

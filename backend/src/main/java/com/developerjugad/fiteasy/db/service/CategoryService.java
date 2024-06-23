package com.developerjugad.fiteasy.db.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.repository.CategoryRepository;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> findCategories() {
        return repository.findAll();
    }

    @Override
    public Category findCategoryById(String id, Category category) {
        return null;
    }

    @Override
    public Category updateCategoryById(String id, Category category) {
        return null;
    }

    @Override
    public Void deleteCategoryById(String id) {
        return null;
    }
}

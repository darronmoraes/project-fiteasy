package com.developerjugad.fiteasy.db.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.repository.CategoryRepository;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.exception.CategoryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

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
    public Category findCategoryById(String id) {
        Optional<Category> optionalCategory = repository.findById(id);

        if (optionalCategory.isEmpty()) {
            log.warn("Resource::category id {} not found", id);
            throw new CategoryNotFoundException("category " + id + " not found");
        }

        return optionalCategory.get();
    }

    @Override
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        repository.delete(category);
    }
}

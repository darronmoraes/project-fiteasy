package com.developerjugad.fiteasy.db.service.interfaces;

import com.developerjugad.fiteasy.db.entity.Category;

import java.util.List;

public interface ICategoryService {

    Category saveCategory(Category category);

    List<Category> findCategories();

    Category findCategoryById(String id, Category category);

    Category updateCategoryById(String id, Category category);

    Void deleteCategoryById(String id);

}

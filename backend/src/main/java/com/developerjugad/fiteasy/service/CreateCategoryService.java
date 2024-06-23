package com.developerjugad.fiteasy.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.model.request.CreateCategoryRequest;
import com.developerjugad.fiteasy.model.response.CreateCategoryResponse;
import com.developerjugad.fiteasy.service.abstraction.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateCategoryService implements RequestHandler<CreateCategoryRequest, CreateCategoryResponse> {

    @Autowired
    private ICategoryService service;

    @Override
    public CreateCategoryResponse invoke(CreateCategoryRequest request) {
        log.info("Request::create category {}", request.getName());

        Category category = mapRequestToEntity(request);

        category = service.saveCategory(category);

        log.info("Request::success, created category");
        return mapCategoryToResponse(category);
    }

    private Category mapRequestToEntity(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    private CreateCategoryResponse mapCategoryToResponse(Category category) {
        return CreateCategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

package com.developerjugad.fiteasy.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.model.request.CreateCategoryInputRequest;
import com.developerjugad.fiteasy.model.response.CreateCategoryOutputResponse;
import com.developerjugad.fiteasy.service.abstraction.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateCategoryService implements RequestHandler<CreateCategoryInputRequest, CreateCategoryOutputResponse> {

    @Autowired
    private ICategoryService service;

    @Override
    public CreateCategoryOutputResponse invoke(CreateCategoryInputRequest request) {
        log.info("Request::create category {}", request.getName());

        Category category = mapRequestToEntity(request);

        category = service.saveCategory(category);

        log.info("Request::success, created category");
        return mapCategoryToResponse(category);
    }

    private Category mapRequestToEntity(CreateCategoryInputRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    private CreateCategoryOutputResponse mapCategoryToResponse(Category category) {
        return CreateCategoryOutputResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

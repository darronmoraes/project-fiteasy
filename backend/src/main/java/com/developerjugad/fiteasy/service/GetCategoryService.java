package com.developerjugad.fiteasy.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.model.request.GetCategoryRequest;
import com.developerjugad.fiteasy.model.response.GetCategoryResponse;
import com.developerjugad.fiteasy.service.abstraction.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetCategoryService implements RequestHandler<GetCategoryRequest, GetCategoryResponse> {

    @Autowired
    private ICategoryService service;

    @Override
    public GetCategoryResponse invoke(GetCategoryRequest request) {
        log.info("Request::get category {}", request.getId());

        Category category = service.findCategoryById(request.getId());

        log.info("Request::success, fetched category");
        return mapCategoryToResponse(category);
    }

    private GetCategoryResponse mapCategoryToResponse(Category category) {
        return GetCategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

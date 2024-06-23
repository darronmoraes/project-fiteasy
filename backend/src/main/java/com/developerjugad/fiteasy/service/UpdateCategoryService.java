package com.developerjugad.fiteasy.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.exception.UpdateRequestException;
import com.developerjugad.fiteasy.model.request.UpdateCategoryRequest;
import com.developerjugad.fiteasy.model.response.GetCategoryResponse;
import com.developerjugad.fiteasy.service.abstraction.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateCategoryService implements RequestHandler<UpdateCategoryRequest, GetCategoryResponse> {

    @Autowired
    private ICategoryService service;

    @Override
    public GetCategoryResponse invoke(UpdateCategoryRequest request) {
        log.info("Request::update category {}", request.getId());

        Category existingCategory = service.findCategoryById(request.getId());
        log.info("Service::found existing category");

        // todo: map new request with existing record
        if (isChanged(request, existingCategory)) {
            updateFields(request, existingCategory);
        }

        existingCategory = service.updateCategory(existingCategory);

        log.info("Request::success, updated category");
        return mapCategoryToResponse(existingCategory);
    }

    private GetCategoryResponse mapCategoryToResponse(Category category) {
        return GetCategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    private void updateFields(UpdateCategoryRequest request, Category existingCategory) {
        existingCategory.setName(request.getName());
        log.info("Request::updating fields");
    }

    private boolean isChanged(UpdateCategoryRequest request, Category existingCategory) {
        if (existingCategory.getName().equals(request.getName())) {
            log.warn("Request::cannot proceed with category {} update, name not changed", existingCategory.getId());
            throw new UpdateRequestException("category name has not been updated");
        }
        return true;
    }
}

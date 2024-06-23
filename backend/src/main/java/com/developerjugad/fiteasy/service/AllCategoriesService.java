package com.developerjugad.fiteasy.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.model.dto.CategoryDTO;
import com.developerjugad.fiteasy.model.response.CategoriesOutputResponse;
import com.developerjugad.fiteasy.service.abstraction.RequestHandler;
import com.developerjugad.fiteasy.service.abstraction.IRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AllCategoriesService implements RequestHandler<IRequest, CategoriesOutputResponse> {

    @Autowired
    private ICategoryService service;


    @Override
    public CategoriesOutputResponse invoke(IRequest request) {
        log.info("Request::all categories");
        List<Category> categories = service.findCategories();

        List<CategoryDTO> categoryDTOList = categories.stream().map(category -> mapCategoryToDto(category)).toList();

        log.info("Request::success");
        return CategoriesOutputResponse.builder().categories(categoryDTOList).build();
    }

    private CategoryDTO mapCategoryToDto(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

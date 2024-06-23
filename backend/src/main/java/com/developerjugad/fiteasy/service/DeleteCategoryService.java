package com.developerjugad.fiteasy.service;

import com.developerjugad.fiteasy.db.entity.Category;
import com.developerjugad.fiteasy.db.service.interfaces.ICategoryService;
import com.developerjugad.fiteasy.model.request.GetCategoryRequest;
import com.developerjugad.fiteasy.service.abstraction.FitEasyResponse;
import com.developerjugad.fiteasy.service.abstraction.RequestHandler;
import com.developerjugad.fiteasy.utility.Constants;
import com.developerjugad.fiteasy.utility.FitEasyHttpCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeleteCategoryService implements RequestHandler<GetCategoryRequest, FitEasyResponse> {

    @Autowired
    private ICategoryService service;

    @Override
    public FitEasyResponse invoke(GetCategoryRequest request) {
        log.info("Request::delete category {}", request.getId());

        Category category = service.findCategoryById(request.getId());

        service.deleteCategory(category);

        log.info("Request::deleted category");
        return FitEasyResponse.builder()
                .status(HttpStatus.OK)
                .message(Constants.SUCCESS_MESSAGE)
                .code(FitEasyHttpCode.OK)
                .build();
    }
}

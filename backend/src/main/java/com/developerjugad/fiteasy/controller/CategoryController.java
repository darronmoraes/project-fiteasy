package com.developerjugad.fiteasy.controller;

import com.developerjugad.fiteasy.model.request.CreateCategoryInputRequest;
import com.developerjugad.fiteasy.model.response.CategoriesOutputResponse;
import com.developerjugad.fiteasy.model.response.CreateCategoryOutputResponse;
import com.developerjugad.fiteasy.service.AllCategoriesService;
import com.developerjugad.fiteasy.service.CreateCategoryService;
import com.developerjugad.fiteasy.service.abstraction.RequestInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CreateCategoryService create;

    @Autowired
    private AllCategoriesService getCategories;

    @PostMapping
    public ResponseEntity<CreateCategoryOutputResponse> create(@Valid @RequestBody CreateCategoryInputRequest request) {
        CreateCategoryOutputResponse response = create.invoke(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CategoriesOutputResponse> allCategories(RequestInput request) {
        CategoriesOutputResponse response = getCategories.invoke(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

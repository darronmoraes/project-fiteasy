package com.developerjugad.fiteasy.controller;

import com.developerjugad.fiteasy.model.request.CreateCategoryInputRequest;
import com.developerjugad.fiteasy.model.request.GetCategoryRequest;
import com.developerjugad.fiteasy.model.request.UpdateCategoryRequest;
import com.developerjugad.fiteasy.model.response.CategoriesOutputResponse;
import com.developerjugad.fiteasy.model.response.CreateCategoryOutputResponse;
import com.developerjugad.fiteasy.model.response.GetCategoryResponse;
import com.developerjugad.fiteasy.service.AllCategoriesService;
import com.developerjugad.fiteasy.service.CreateCategoryService;
import com.developerjugad.fiteasy.service.GetCategoryService;
import com.developerjugad.fiteasy.service.UpdateCategoryService;
import com.developerjugad.fiteasy.service.abstraction.RequestInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @Autowired
    private GetCategoryService getCategory;

    @Autowired
    private UpdateCategoryService update;

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

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryResponse> allCategories(@NotBlank @PathVariable(value = "id") String categoryId) {
        GetCategoryRequest request = new GetCategoryRequest(categoryId);
        GetCategoryResponse response = getCategory.invoke(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetCategoryResponse> update(@NotBlank @PathVariable(value = "id") String categoryId, @RequestBody UpdateCategoryRequest request) {
        request.setId(categoryId);
        GetCategoryResponse response = update.invoke(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

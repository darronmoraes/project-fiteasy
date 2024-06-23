package com.developerjugad.fiteasy.model.request;

import com.developerjugad.fiteasy.service.abstraction.RequestInput;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest implements RequestInput {

    private String id;

    @NotNull
    @NotEmpty
    @JsonProperty("name")
    private String name;
}

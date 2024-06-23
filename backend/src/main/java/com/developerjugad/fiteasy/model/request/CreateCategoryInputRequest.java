package com.developerjugad.fiteasy.model.request;

import com.developerjugad.fiteasy.service.abstraction.IRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryInputRequest implements IRequest {

    @NotNull
    @NotEmpty
    @JsonProperty("name")
    private String name;
}

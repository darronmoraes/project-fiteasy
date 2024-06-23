package com.developerjugad.fiteasy.model.request;

import com.developerjugad.fiteasy.service.abstraction.RequestInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryRequest implements RequestInput {

    private String id;
}

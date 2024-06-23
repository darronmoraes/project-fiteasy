package com.developerjugad.fiteasy.model.response;

import com.developerjugad.fiteasy.model.dto.CategoryDTO;
import com.developerjugad.fiteasy.service.abstraction.ResponseOutput;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoriesOutputResponse implements ResponseOutput {

    List<CategoryDTO> categories;

}

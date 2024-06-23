package com.developerjugad.fiteasy.model.response;

import com.developerjugad.fiteasy.model.dto.CategoryDTO;
import com.developerjugad.fiteasy.service.abstraction.IResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoriesOutputResponse implements IResponse {

    List<CategoryDTO> categories;

}

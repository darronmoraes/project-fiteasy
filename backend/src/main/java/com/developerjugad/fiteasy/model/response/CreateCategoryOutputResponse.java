package com.developerjugad.fiteasy.model.response;

import com.developerjugad.fiteasy.service.abstraction.IResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCategoryOutputResponse implements IResponse {

    private String id;
    private String name;

}

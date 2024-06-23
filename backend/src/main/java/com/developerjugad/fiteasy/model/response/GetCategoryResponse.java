package com.developerjugad.fiteasy.model.response;

import com.developerjugad.fiteasy.service.abstraction.IResponse;
import lombok.*;

@Data
@Builder
public class GetCategoryResponse implements IResponse {

    private String id;
    private String name;

}

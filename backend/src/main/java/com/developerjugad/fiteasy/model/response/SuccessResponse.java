package com.developerjugad.fiteasy.model.response;

import com.developerjugad.fiteasy.service.abstraction.ResponseOutput;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SuccessResponse implements ResponseOutput {

    private HttpStatus status;
    private String message;
    private Integer code;
}

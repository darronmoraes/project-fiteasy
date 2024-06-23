package com.developerjugad.fiteasy.service.abstraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class FitEasyResponse implements IResponse {

    private HttpStatus status;
    private String message;
    private Integer code;
}

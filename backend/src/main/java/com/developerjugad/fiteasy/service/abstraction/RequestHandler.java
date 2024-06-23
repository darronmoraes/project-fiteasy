package com.developerjugad.fiteasy.service.abstraction;

public interface RequestHandler<I extends IRequest, O extends IResponse> {
    O invoke(I request);
}

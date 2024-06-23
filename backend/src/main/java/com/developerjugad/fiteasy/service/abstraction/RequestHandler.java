package com.developerjugad.fiteasy.service.abstraction;

public interface RequestHandler<I extends RequestInput, O extends ResponseOutput> {
    O invoke(I request);
}

package com.developerjugad.fiteasy.exception;

public class UpdateRequestException extends RuntimeException {
    public UpdateRequestException() {
    }

    public UpdateRequestException(String message) {
        super(message);
    }

    public UpdateRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateRequestException(Throwable cause) {
        super(cause);
    }

    public UpdateRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

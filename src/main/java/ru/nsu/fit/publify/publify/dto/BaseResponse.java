package ru.nsu.fit.publify.publify.dto;

import ru.nsu.fit.publify.publify.exception.BaseException;

public class BaseResponse<T> {
    private T result;
    private BaseException exception;

    public BaseResponse(T result) {
        if (result instanceof BaseException exception) {
            this.exception = exception;
        } else {
            this.result = result;
        }
    }
}

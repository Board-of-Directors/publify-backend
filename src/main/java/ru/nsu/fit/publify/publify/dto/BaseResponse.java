package ru.nsu.fit.publify.publify.dto;

import lombok.Data;
import ru.nsu.fit.publify.publify.exception.BaseException;

@Data
public class BaseResponse<T> {
    private T result;
    private ResponseExceptionDto exception;

    public BaseResponse(T result) {
        if (result instanceof BaseException ex) {
            this.exception = new ResponseExceptionDto(ex.getMessage());
        } else {
            this.result = result;
        }
    }
}

package com.example.snap.exception;

import com.example.snap.constant.ReturnCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthException extends RuntimeException {
    private String code;
    private Object data;

    public AuthException(ReturnCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    public AuthException(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public AuthException(String message, String code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}

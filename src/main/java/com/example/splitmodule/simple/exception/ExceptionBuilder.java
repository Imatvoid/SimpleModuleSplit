package com.example.splitmodule.simple.exception;


public abstract class ExceptionBuilder {

    public static XXException buildException(ErrorCodeEnum codeEnum, Object... args) {
        XXException xxException = AbstractException.build(XXException.class, codeEnum.getCode(), args);
        xxException.setErrorMessage(String.format(codeEnum.getPlaceholderLayout(), args));
        return xxException;
    }
}

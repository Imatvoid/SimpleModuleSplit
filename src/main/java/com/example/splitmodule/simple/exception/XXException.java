package com.example.splitmodule.simple.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义的特定异常,这里使用xx代替.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XXException extends AbstractException {

    private static final long serialVersionUID = 7234284377253528769L;
    private String errorMessage;
}
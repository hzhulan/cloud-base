package com.fh.exception;

/**
 * @file: BusinessRuntimeException
 * @version: 1.0
 * @Description: 业务异常
 * @Author: pp_lan
 * @Date: 2021/5/7
 */
public class BusinessRuntimeException extends RuntimeException {

    public BusinessRuntimeException(String message) {
        super(message);
    }

    public BusinessRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}

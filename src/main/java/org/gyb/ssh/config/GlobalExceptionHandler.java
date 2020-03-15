package org.gyb.ssh.config;


import org.gyb.ssh.pojo.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，捕获和处理所有的异常，统一包装异常为ResponseResult
 *
 * @see ResponseResult
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult exceptionHandle(Exception e) {
        return ResponseResult.of(e);
    }
}

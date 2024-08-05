package com.it.wang.Handle;

import com.it.wang.resp.Result;
import com.it.wang.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result Exception(Exception exception){
        exception.printStackTrace();
        return Result.error(ReturnCodeEnum.RC500.getCode(),exception.getMessage());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public Result runtimeException(RuntimeException exception){
        log.error(exception.getMessage());
        return Result.error(ReturnCodeEnum.RC500.getCode(),exception.getMessage());
    }

}

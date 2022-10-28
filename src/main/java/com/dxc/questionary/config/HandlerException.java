package com.dxc.questionary.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huang
 */
@ControllerAdvice
@Slf4j
public class HandlerException {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info(e.getBindingResult().getFieldError().getDefaultMessage());
        return JSONResult.Failed(e.getBindingResult().getFieldError().getDefaultMessage(), null);
    }
}

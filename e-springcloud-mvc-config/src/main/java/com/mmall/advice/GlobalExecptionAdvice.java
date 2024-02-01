package com.mmall.advice;

import com.mmall.VO.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExecptionAdvice {

    @ExceptionHandler
    public CommonResponse<String> handlerCommerceExecption(HttpServletRequest req,Exception ex){
        CommonResponse<String> response = new CommonResponse<>(-1,"business error");
        response.setData(ex.getMessage());
        log.error("error !!!  :  [{}]",ex.getMessage(),ex);
        return response;
    }
}

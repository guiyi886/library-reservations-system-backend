package com.student.handler;

import com.student.exctptions.AccountException;
import com.student.exctptions.BookFailException;
import com.student.exctptions.JwtCheckException;
import com.student.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public Result AccountexceptionHandler(AccountException e){
        log.info("登录失败");
        return Result.error(e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public Result jwtexceptionHandler(JwtCheckException e){
        log.info("令牌校验失败");
        return Result.error(e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public Result BookExceptionHandler(BookFailException e){
        log.info("预约失败");
        return Result.error(e.getMessage());
    }
}

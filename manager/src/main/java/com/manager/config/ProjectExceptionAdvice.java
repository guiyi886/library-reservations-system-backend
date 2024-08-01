package com.manager.config;


import com.manager.exctptions.*;
import com.manager.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author guiyi
 * @date 2023/12/17 03:44:11
 * @className com.manager.config.ProjectExceptionAdvice
 * @function 处理异常情况，将异常信息包装成自定义的 Result 对象，并提醒【后端】，返回【前端】！！！
 */
@RestControllerAdvice   //定义全局性的异常处理器
@Slf4j
public class ProjectExceptionAdvice {
    /**
     * * 处理 ManagerException，将异常信息包装成自定义的 Result 对象，并返回。
     */
    @ExceptionHandler(ManagertException.class)
    public Result doManagertException(ManagertException ex) {
        log.info(ex.getMessage());
        ex.printStackTrace();
        return Result.error(ex.getMessage());
    }

    /**
     * @date 2023/12/19 04:15:55
     * @function --> jwt校检
     */
    @ExceptionHandler(JwtCheckException.class)
    public Result doJwtCheckException(JwtCheckException ex) {
        log.info(ex.getMessage());
        ex.printStackTrace();
        return Result.error(ex.getMessage());
    }

    /**
     * @date 2023/12/19 04:15:48
     * @function --> 签到
     */
    @ExceptionHandler(ArriveException.class)
    public Result doArriveException(ArriveException ex) {
        log.info(ex.getMessage());
        ex.printStackTrace();
        return Result.error(ex.getMessage());
    }

    /**
     * @date 2023/12/19 04:15:29
     * @function --> 阅览室
     */
    @ExceptionHandler(RoomException.class)
    public Result doRoomException(RoomException ex) {
        log.info(ex.getMessage());
        ex.printStackTrace();
        return Result.error(ex.getMessage());
    }

    /**
     * @date 2023/12/19 04:42:27
     * @function --> 座位
     */
    @ExceptionHandler(SeatException.class)
    public Result doSeatException(SeatException ex) {
        log.info(ex.getMessage());
        ex.printStackTrace();
        return Result.error(ex.getMessage());
    }

    /**
     * 处理通用的 Exception，将异常信息包装成自定义的 Result 对象，并返回。
     */
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex) {
        ex.printStackTrace();
        return Result.error("系统错误");
    }
}

package com.student.exctptions;

/**
 * 登录失败异常
 */
public class AccountException extends RuntimeException{
    public AccountException(){}

    public AccountException(String msg){
        super(msg);
    }
}

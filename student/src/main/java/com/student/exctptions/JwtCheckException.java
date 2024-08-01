package com.student.exctptions;

/**
 * 令牌校验异常
 */
public class JwtCheckException extends RuntimeException{
    JwtCheckException(){}
    public JwtCheckException(String msg){super(msg);}
}

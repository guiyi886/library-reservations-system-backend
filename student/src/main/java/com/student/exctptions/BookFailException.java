package com.student.exctptions;

public class BookFailException extends RuntimeException{
    BookFailException(){}
    public BookFailException(String msg){super(msg);}
}

package com.JParser.exception;

public class BasicException extends RuntimeException {
    public BasicException(String msg){
        super(msg,null,true,false);
    }
}

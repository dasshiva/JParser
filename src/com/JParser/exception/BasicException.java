package com.JParser.exception;

public class BasicException extends RuntimeException {
    public BasicException(String msg){
        super("\n" + msg,null,true,false);
    }
}

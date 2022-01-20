package com.JParser.exception;

public class NoArgException extends BasicException {
    public NoArgException(String opt){
        super("Option "+ opt + " needs an argument");
    }
}

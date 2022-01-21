package com.JParser.parser.exception;

public class UnexpectedTokenException extends ParserException {
    public UnexpectedTokenException (char token){
        super ("Token "+ token + " is not expected here");
    }
}

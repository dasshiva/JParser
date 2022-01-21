package com.JParser.parser.exception;

public class UnexpectedTokenException extends ParserException {
    public UnexpectedTokenException (char token){
        super ("Token "+ transform(token) + " is not expected here");
    }
    private static String transform (char ch){
	    return switch (ch) {
		    case '\n' : yield "newline";
		    case ' ' :  yield "whitespace";
		    default :  yield Character.toString(ch);
	    };
    }
}

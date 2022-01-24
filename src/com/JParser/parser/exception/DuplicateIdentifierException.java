package com.JParser.parser.exception;

public class DuplicateIdentifierException extends ParserException {
    public DuplicateIdentifierException (String identifier) {
        super("Identifier " + identifier + "has already been declared earlier");
    }
}

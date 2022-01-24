package com.JParser.parser.exception;

import com.JParser.exception.BasicException;

public class DuplicateIdentifierException extends ParserException {
    public DuplicateIdentifierException (String identifier) {
        super("Identifier " + identifier + "has already been declared earlier");
    }
}

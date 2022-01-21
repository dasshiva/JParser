package com.JParser.parser.exception;

import com.JParser.Props;
import com.JParser.exception.BasicException;

public class ParserException extends BasicException  {
    public ParserException(String cause){
        super(String.format("At %s:%d %s\n%s",Props.getProp("input"),
                Integer.getInteger(Props.getProp("lineno")),
                cause, Props.getProp("line")));
    }
}

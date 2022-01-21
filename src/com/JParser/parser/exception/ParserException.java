package com.JParser.parser.exception;

import com.JParser.Props;
import com.JParser.exception.BasicException;

public class ParserException extends BasicException  {
    public ParserException(String cause){
        super(String.format("\n%s\n%s:%d %s",Props.getProp("line"),
		Props.getProp("input"),
                Integer.parseInt(Props.getProp("lineno")),cause));
    }
}

package com.JParser.parser.exception;

import com.JParser.Props;
import com.JParser.exception.BasicException;

public class ParserException extends BasicException  {
    public ParserException(String cause,String hint){
        super(String.format("\n%s\n%s:%d %s\n" +
                        "Were you trying to : %s ?",
                Props.getProp("line"),
                Props.getProp("input"),
                Integer.parseInt(Props.getProp("lineno")),
                cause,hint));
    }
    public ParserException(String cause) {
        super(String.format("\n%s\n%s:%d %s\n",
                Props.getProp("line"),
                Props.getProp("input"),
                Integer.parseInt(Props.getProp("lineno")),
                cause));
    }
}

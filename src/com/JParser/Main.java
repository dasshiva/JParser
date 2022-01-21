package com.JParser;

import com.JParser.parser.ParserMain;

public class Main {
    public static void main(String[] args) {
        Props.initProps();
        CommandParser cp = new CommandParser(args);
        cp.parseAll();
        ParserMain pm = new ParserMain(new IO(Props.getProp("input")));
        pm.parse();
    }
}

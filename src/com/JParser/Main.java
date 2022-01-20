package com.JParser;

public class Main {
    public static void main(String[] args) {
        Props.initProps();
        CommandParser cp=new CommandParser(args);
    }
}

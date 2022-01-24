package com.JParser.parser;

import com.JParser.IO;
import com.JParser.Props;
import com.JParser.exception.ReaderException;

import java.io.IOException;

public class ParserMain {
    private final IO reader;
    public ParserMain(IO readFrom){
        reader=readFrom;
    }
    public void parse() {
        String line;
        try {
            Split sp = new Split(reader);
            String text = "";
            while (!text.equals("EOF")) {
                sp.getNext();
                while (sp.hasNext()) {
                    text = sp.next();
                    System.out.println(text);
                }
            }
        }
        catch (IOException err) {
            throw new ReaderException(reader.getFilename(), err.getMessage());
        }
    }
}

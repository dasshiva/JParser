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
        try {
            TokenProcessor tp = new TokenProcessor(new Split(reader));
            while (!tp.isFinished()) {
                tp.parse();
            }
        }
        catch (IOException err) {
            throw new ReaderException(reader.getFilename(), err.getMessage());
        }
    }
}

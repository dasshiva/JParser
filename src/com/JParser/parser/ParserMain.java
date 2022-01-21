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
            while (!(line = reader.read()).equals("EOF")) {
                    Props.addProp("lineno", Integer.toString(reader.getLineno()));
                    Props.addProp("line", line);
                    int index;
                    if ((index = Comment.commentIndex(line))==0)
                        continue;
                    else {
                        // NOT IMPLEMENTED YET
                    }
            }
        }
        catch (IOException err) {
            throw new ReaderException(reader.getFilename(), err.getMessage());
        }
    }
}

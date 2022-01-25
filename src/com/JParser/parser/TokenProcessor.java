package com.JParser.parser;

import com.JParser.parser.exception.UnexpectedTokenException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class TokenProcessor {
    private final Split src;
    private ArrayList list;
    private final SymbolTable sym = new SymbolTable();
    private boolean finished;
    public TokenProcessor (Split s){
        src = s;
    }
    public void parse () throws IOException {
        if (finished)
            return;
        src.getNext();
        while (src.hasNext()){
            String line = src.next();
            if (line.equals("EOF")) {
                finished = true;
                return;
            }
            Tokens.Handle(line);
        }
        list = Tokens.returnList();
        parseList();
    }
    private void parseList() {
        AccessMods am = null;
        BuiltinTypes bt = null;
        OptionalMods om = null;
        boolean decl = false, expectingId = false , expectAssign = false ,expectVal = false;
        String ID = null;
        BitSet attr = null;
        var iter = list.iterator();
        while(iter.hasNext()){
            Object toParse = iter.next();
            if (toParse instanceof AccessMods) {
                am = (AccessMods) toParse;
                decl = true;
            }
            else if (toParse instanceof BuiltinTypes) {
                bt = (BuiltinTypes) toParse;
                decl = true;
                expectingId = true;
            }
            else if (toParse instanceof OptionalMods) {
                om = (OptionalMods) toParse;
                decl = true;
            }
            else {
                if (decl && expectingId) {
                    if (toParse instanceof String) {
                        ID = (String) toParse;
                        attr = makeAttribs(am,om,bt);
                        expectingId = false;
                        expectAssign = true;
                    }
                    else
                        throw new UnexpectedTokenException("identifier");
                }
                else if (expectAssign) {
                    if (!(toParse instanceof String) || !toParse.equals("="))
                        throw new UnexpectedTokenException("assignment operator '='");
                    else
                        expectVal = true;
                }
                else if (expectVal) {
                    if (!(toParse instanceof String))
                        throw new UnexpectedTokenException(String.format("value for variable %s ",ID));
                    else
                        sym.addSymbol(ID,toParse,attr);
                }
            }
        }
    }
    private BitSet makeAttribs (AccessMods am, OptionalMods om, BuiltinTypes bt){
        BitSet attr = new BitSet();
        switch (am){
            case ACC_PRIVATE :
                attr.flip(0);
                break;
            case ACC_PROTECTED:
                attr.flip(1);
                break;
            case ACC_PUBLIC:
                attr.flip(2);
                break;
        }

        if (om == OptionalMods.MOD_STATIC)
            attr.flip(3);

        switch (bt) {
            case TYPE_CHAR:
                attr.flip(4);
                break;
            case TYPE_BYTE:
                attr.flip(5);
                break;
            case TYPE_SHORT:
                attr.flip(6);
                break;
            case TYPE_INT:
                attr.flip(7);
                break;
            case TYPE_LONG:
                attr.flip(8);
                break;
            case TYPE_FLOAT:
                attr.flip(9);
                break;
            case TYPE_DOUBLE:
                attr.flip(10);
        }
        return attr;
    }
    public boolean isFinished() {
        return finished;
    }
}

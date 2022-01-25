package com.JParser.parser;

import java.util.ArrayList;

public class Tokens {
    private final static ArrayList<Object> tokenList = new ArrayList<>();
    public static void Handle (String token){
        switch (token) {
            case "public":
                tokenList.add(AccessMods.ACC_PUBLIC);
                break;
            case "private":
                tokenList.add(AccessMods.ACC_PRIVATE);
                break;
            case "protected":
                tokenList.add(AccessMods.ACC_PROTECTED);
                break;
            case "static" :
                tokenList.add(OptionalMods.MOD_STATIC);
                break;
            case "char":
                tokenList.add(BuiltinTypes.TYPE_CHAR);
                break;
            case "byte":
                tokenList.add(BuiltinTypes.TYPE_BYTE);
                break;
            case "short":
                tokenList.add(BuiltinTypes.TYPE_SHORT);
                break;
            case "int":
                tokenList.add(BuiltinTypes.TYPE_INT);
                break;
            case "long":
                tokenList.add(BuiltinTypes.TYPE_LONG);
                break;
            case "float":
                tokenList.add(BuiltinTypes.TYPE_FLOAT);
                break;
            case "double":
                tokenList.add(BuiltinTypes.TYPE_DOUBLE);
                break;
            default:
                tokenList.add(token);
        }
    }

    public static ArrayList returnList(){
        return tokenList;
    }
    public static void reset (){
        tokenList.clear();
    }
}

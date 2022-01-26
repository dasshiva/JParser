package com.JParser.parser;

public enum BuiltinTypes implements Transform {
    TYPE_CHAR, TYPE_BYTE, TYPE_SHORT,
    TYPE_INT, TYPE_LONG,
    TYPE_FLOAT, TYPE_DOUBLE;

    @Override 
    public String transform(){
	    switch(this){
		    case TYPE_CHAR: return "char";
		    case TYPE_BYTE: return "byte";
		    case TYPE_SHORT: return "short";
		    case TYPE_INT: return "int";
		    case TYPE_LONG: return "long";
		    case TYPE_FLOAT: return "float";
		    case TYPE_DOUBLE: return "double";
	    }
	    return null;
    }
}

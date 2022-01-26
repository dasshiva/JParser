package com.JParser.parser;

public enum AccessMods implements Transform {
    ACC_PUBLIC,
    ACC_PRIVATE,
    ACC_PROTECTED;

    @Override 
    public String transform() {
	    switch(this){
		    case ACC_PUBLIC: return "public";
		    case ACC_PRIVATE: return "private";
		    case ACC_PROTECTED: return "protected";
	    }
	    return null;
    }
}

package com.JParser.parser;

import java.util.Iterator;

public class Split implements Iterator<String> {
	private String currentString = "" , toParse;
	private int currentIndex;
	private boolean isLeft = true;
	public Split (String line,int fromIndex) {
		if (fromIndex == -1)
			currentIndex = 0;
		else 
			currentIndex = fromIndex;
		toParse = line;
	}
	private void split(){
		StringBuilder sb = new StringBuilder();
		for (int i = currentIndex; i<toParse.length(); i++){
			char ins = toParse.charAt(i);
			if (!Character.isWhitespace(ins))
				sb.append(ins);
			else {
				currentIndex = i+1;
				if (currentIndex >= toParse.length())
					isLeft = false;
				currentString = sb.toString();
				return;
			}
		}
	}
	public String next() {
		split();
		return currentString;
	}
	public boolean hasNext(){
		return isLeft;
	}
}

package com.gabrielsuch.collectionsorter.infra.util;

public class StringUtils {

	public static String capitalize(String word) {
		char firstCharAsUpper = Character.toUpperCase(word.charAt(0));
		String wordWithoutFirstChar = word.substring(1, word.length());
		
		return firstCharAsUpper + wordWithoutFirstChar;
	}

}

package com.gabrielsuch.collectionsorter.infra.util;

public class Preconditions {
	
	public static void checkNotNull(Object object) {
		if (object == null) throw new IllegalArgumentException();
	}

}

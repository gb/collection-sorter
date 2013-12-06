package com.gabrielsuch.collectionsorter.infra;

import static com.gabrielsuch.collectionsorter.infra.util.StringUtils.capitalize;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void shouldReturnCapitalizedValue() {
		assertEquals("Hello", capitalize("hello"));
		assertEquals("Hi", capitalize("Hi"));
	}

}

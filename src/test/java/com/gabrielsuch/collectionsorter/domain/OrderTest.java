package com.gabrielsuch.collectionsorter.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderTest {
	
	private Order order;
	
	@Test
	public void shouldGetFalseWhenAskIfTheSortOrderIsDescToANonSpecifiedOrder() {
		order = new Order("name");
		assertFalse(order.isDesc());
	}
	
	@Test
	public void shouldGetTrueWhenAskIfTheSortOrderIsDescToADescSpecifiedOrder() {
		order = new Order("name", SortOrder.DESC);
		assertTrue(order.isDesc());
	}
	
	@Test
	public void testToStringMethod() {
		assertEquals("name", new Order("name").toString());
		assertEquals("name DESC", new Order("name", SortOrder.DESC).toString());		
	}

}

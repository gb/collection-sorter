package com.gabrielsuch.collectionsorter.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderCriteriaTest {
	
	private OrderCriteria orderCriteria;
	
	@Test
	public void testEnsureTheIndexOfOrders() {
		orderCriteria = new OrderCriteria(
			new Order("color"),
			new Order("year"),
			new Order("price")
		);
		
		assertEquals(orderCriteria.getCriteria().get(0).getField(), "color");
		assertEquals(orderCriteria.getCriteria().get(1).getField(), "year");
		assertEquals(orderCriteria.getCriteria().get(2).getField(), "price");
	}

}

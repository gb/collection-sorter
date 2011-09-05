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
		
		assertEquals("[color, year, price]", orderCriteria.getCriteria().toString());
	}

	@Test
	public void testEnsureTheIndexOfOrdersWithStringParametersConstructor() {
		orderCriteria = new OrderCriteria("color", "year", "price");
		
		assertEquals("[color, year, price]", orderCriteria.getCriteria().toString());
	}

}

package com.gabrielsuch.collectionsorter.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderCriteria {
	
	private final List<Order> orderCriteria = new ArrayList<Order>();
	
	public void addOrder(Order order) {
		orderCriteria.add(order);
	}

	public List<Order> getCriteria() {
		return Collections.unmodifiableList(orderCriteria);
	}
	
}

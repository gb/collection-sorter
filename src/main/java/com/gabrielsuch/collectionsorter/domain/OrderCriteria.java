package com.gabrielsuch.collectionsorter.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderCriteria {
	
	private final List<Order> orderCriteria = new ArrayList<Order>();
	
	public OrderCriteria(Order... orders) {
		for (Order order : orders) orderCriteria.add(order);
	}
		
	public OrderCriteria(String... fieldNames) {
		for (String fieldName : fieldNames) orderCriteria.add(new Order(fieldName));
	}

	public List<Order> getCriteria() {
		return Collections.unmodifiableList(orderCriteria);
	}
	
}

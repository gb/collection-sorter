package com.gabrielsuch.collectionsorter.domain;

public class Order {
	
	private String field;
	private SortOrder sortOrder = SortOrder.ASC;
	
	public Order(Class<?> clazz, String field) {
		this.field = field;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getField() {
		return field;
	}
	
	public boolean isDesc() {
		return sortOrder.equals(SortOrder.DESC);
	}

}

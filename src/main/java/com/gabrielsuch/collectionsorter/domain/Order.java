package com.gabrielsuch.collectionsorter.domain;

public class Order {
	
	private final String field;
	private final SortOrder sortOrder;
	
	public Order(String field) {
		this.field = field;
		this.sortOrder = SortOrder.ASC;
	}
	
	public Order(String field, SortOrder sortOrder) {
		this.field = field;
		this.sortOrder = sortOrder;
	}

	public String getField() {
		return field;
	}
	
	public boolean isDesc() {
		return SortOrder.DESC == this.sortOrder;
	}

}

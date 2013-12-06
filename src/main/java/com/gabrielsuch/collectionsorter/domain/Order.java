package com.gabrielsuch.collectionsorter.domain;

public class Order {
	
	public static final SortOrder DEFAULT_ORDER = SortOrder.ASC;
	
	private final String field;
	private final SortOrder sortOrder;
	
	public Order(String field) {
		this.field = field;
		this.sortOrder = DEFAULT_ORDER;
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

	public String toString() {
		if (sortOrder == DEFAULT_ORDER) return field;
		return field + " " + sortOrder;
	}
	
}

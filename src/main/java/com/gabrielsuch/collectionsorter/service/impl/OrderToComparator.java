package com.gabrielsuch.collectionsorter.service.impl;

import org.apache.commons.collections15.comparators.ComparatorChain;

import com.gabrielsuch.collectionsorter.domain.Order;
import com.gabrielsuch.collectionsorter.domain.OrderCriteria;
import com.gabrielsuch.collectionsorter.infra.util.GenericBeanComparator;

class OrderToComparator<T> {

	protected ComparatorChain<T> convert(OrderCriteria orderCriteria) {
		ComparatorChain<T> multipleComparator = new ComparatorChain<T>();
		
		for (Order order : orderCriteria.getCriteria()) 
			multipleComparator.addComparator(comparator(order), order.isDesc());
		
		return multipleComparator;
	}
	
	private GenericBeanComparator<T> comparator(Order order) {
		return new GenericBeanComparator<T>(order.getField());
	}

}

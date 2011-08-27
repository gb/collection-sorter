package com.gabrielsuch.collectionsorter.service.impl;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import com.gabrielsuch.collectionsorter.domain.Order;
import com.gabrielsuch.collectionsorter.domain.OrderCriteria;

class OrderToComparator {

	protected static ComparatorChain convert(OrderCriteria orderCriteria) {
		ComparatorChain multipleComparator = new ComparatorChain();
		
		for (Order order : orderCriteria.getCriteria()) 
			multipleComparator.addComparator(comparator(order), order.isDesc());
		
		return multipleComparator;
	}
	
	private static BeanComparator comparator(Order order) {
		return new BeanComparator(order.getField());
	}

}

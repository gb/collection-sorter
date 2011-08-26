package com.gabrielsuch.collectionsorter.service;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import com.gabrielsuch.collectionsorter.domain.Order;
import com.gabrielsuch.collectionsorter.domain.OrderCriteria;

public class OrderToComparator {

	public static ComparatorChain convert(OrderCriteria orderCriteria) {
		ComparatorChain multipleComparator = new ComparatorChain();
		
		for (Order order : orderCriteria.getCriteria()) {
			multipleComparator.addComparator(new BeanComparator(order.getField()), order.isDesc());
		}
		
		return multipleComparator;
	}

}

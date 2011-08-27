package com.gabrielsuch.collectionsorter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.comparators.ComparatorChain;

import com.gabrielsuch.collectionsorter.domain.Order;
import com.gabrielsuch.collectionsorter.domain.OrderCriteria;
import com.gabrielsuch.collectionsorter.infra.exception.OrderException;
import com.gabrielsuch.collectionsorter.infra.util.ReflectionUtils;
import com.gabrielsuch.collectionsorter.service.CollectionSorter;
import com.google.common.base.Preconditions;

public class CollectionSorterImpl<T> implements CollectionSorter<T> {

	private List<T> collection;
	
	public CollectionSorterImpl(Collection<T> collection) {
		this.collection = new ArrayList<T>(collection);
	}
	
	@Override
	public List<T> sortBy(OrderCriteria orderCriteria) {
		if (collection.isEmpty()) return collection;
		sanityCheck(orderCriteria);
		
		ComparatorChain orderBy = OrderToComparator.convert(orderCriteria);
		Collections.sort(collection, orderBy);
		
		return collection;
	}

	private void sanityCheck(OrderCriteria orderCriteria) {
		Preconditions.checkNotNull(orderCriteria);
		Class<?> clazz = collection.get(0).getClass();
		
		for (Order order : orderCriteria.getCriteria()) {
			if ( ReflectionUtils.classContainsField(clazz, order.getField()) ) continue;
			throw new OrderException("The field " + order.getField() + " was not found.");
		}
	}
	
}

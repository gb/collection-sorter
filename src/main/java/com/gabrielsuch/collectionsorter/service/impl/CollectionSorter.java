package com.gabrielsuch.collectionsorter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.comparators.ComparatorChain;

import com.gabrielsuch.collectionsorter.domain.Order;
import com.gabrielsuch.collectionsorter.domain.OrderCriteria;
import com.gabrielsuch.collectionsorter.domain.SortOrder;
import com.gabrielsuch.collectionsorter.infra.exception.OrderException;
import com.gabrielsuch.collectionsorter.infra.util.Preconditions;
import com.gabrielsuch.collectionsorter.infra.util.ReflectionUtils;
import com.gabrielsuch.collectionsorter.service.ICollectionSorter;

public class CollectionSorter<T> implements ICollectionSorter<T> {

	private final List<T> collection;
	
	public CollectionSorter(Collection<T> collection) {
		Preconditions.checkNotNull(collection);
		this.collection = new ArrayList<T>(collection);
	}
	
	@Override
	public List<T> sortBy(OrderCriteria orderCriteria) {
		if (orderCriteria == null || collection.isEmpty()) return collection;
		
		return sort(orderCriteria);
	}
	
	@Override
	public List<T> sortBy(String fieldName) {
		return sortBy(fieldName, SortOrder.ASC);
	}
	
	@Override
	public List<T> sortBy(String fieldName, SortOrder sortOrder) {
		if (fieldName == null) return collection;
		
		return sort(new OrderCriteria(new Order(fieldName, sortOrder)));
	}
	
	private List<T> sort(OrderCriteria orderCriteria) {
		sanityCheck(orderCriteria);
		
		ComparatorChain orderBy = new OrderToComparator().convert(orderCriteria);
		Collections.sort(collection, orderBy);
		
		return collection;
	}

	private void sanityCheck(OrderCriteria orderCriteria) {
		Class<?> clazz = collection.get(0).getClass();
		
		for (Order order : orderCriteria.getCriteria()) {
			if ( ReflectionUtils.classContainsGetter(clazz, order.getField()) ) continue;
			throw new OrderException("The getter for " + order.getField() + " was not found.");
		}
	}
	
}

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
		return sort(orderCriteria);
	}
	
	@Override
	public List<T> sortBy(String fieldName) {
		return sortBy(fieldName, SortOrder.ASC);
	}
	
	@Override
	public List<T> sortBy(String fieldName, SortOrder sortOrder) {
		return sort(new OrderCriteria(new Order(fieldName, sortOrder)));
	}
	
	@SuppressWarnings("unchecked")
	private List<T> sort(OrderCriteria orderCriteria) {
		if (orderCriteria == null || collection.isEmpty()) return collection;
		sanityCheck(orderCriteria);
		
		ComparatorChain orderBy = new OrderToComparator().convert(orderCriteria);
		Collections.sort(collection, orderBy);
		
		return collection;
	}

	private void sanityCheck(OrderCriteria orderCriteria) {
		Class<?> clazz = collection.get(0).getClass();
		for (Order order : orderCriteria.getCriteria()) testExistenceOfGetter(clazz, order);
	}

	private void testExistenceOfGetter(Class<?> clazz, Order order) {
		if ( ReflectionUtils.classContainsGetter(clazz, order.getField()) ) return;
		throw new OrderException("The getter for " + order.getField() + " was not found.");
	}
	
}

package com.gabrielsuch.collectionsorter.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.comparators.ComparatorChain;

import com.gabrielsuch.collectionsorter.domain.OrderCriteria;
import com.google.common.base.Preconditions;

public class CollectionSorter<T> {

	private List<T> collection;
	
	public CollectionSorter(Collection<T> collection) {
		this.collection = new ArrayList<T>(collection);
	}
	
	public List<T> sortBy(OrderCriteria orderCriteria) {
		Preconditions.checkNotNull(orderCriteria);
		if (collection.isEmpty()) return collection;
		
		ComparatorChain orderBy = OrderToComparator.convert(orderCriteria);
		Collections.sort(collection, orderBy);
		
		return collection;
	}
	
}

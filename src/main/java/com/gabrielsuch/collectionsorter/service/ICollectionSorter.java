package com.gabrielsuch.collectionsorter.service;

import java.util.List;

import com.gabrielsuch.collectionsorter.domain.OrderCriteria;
import com.gabrielsuch.collectionsorter.domain.SortOrder;

public interface ICollectionSorter<T> {

	List<T> sortBy(OrderCriteria orderCriteria);
	
	List<T> sortBy(String fieldName);
	
	List<T> sortBy(String fieldName, SortOrder sortOrder);

}
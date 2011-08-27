package com.gabrielsuch.collectionsorter.service;

import java.util.List;

import com.gabrielsuch.collectionsorter.domain.OrderCriteria;

public interface CollectionSorter<T> {

	List<T> sortBy(OrderCriteria orderCriteria);

}
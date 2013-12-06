package com.gabrielsuch.collectionsorter.infra.util;

import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;

public class GenericBeanComparator<T> implements Comparator<T> {

	private final BeanComparator delegate;

	public GenericBeanComparator(String property) {
		delegate = new BeanComparator(property);
	}

	public int compare(T a, T b) {
		return delegate.compare(a, b);
	}
	
}

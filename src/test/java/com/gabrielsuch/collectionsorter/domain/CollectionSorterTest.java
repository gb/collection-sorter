package com.gabrielsuch.collectionsorter.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gabrielsuch.collectionsorter.domain.testdouble.Car;
import com.gabrielsuch.collectionsorter.infra.exception.OrderException;
import com.gabrielsuch.collectionsorter.service.impl.CollectionSorter;

public class CollectionSorterTest {
	
	private List<Car> collection = new ArrayList<Car>();
	
	@Before
	public void setup() {
		collection.add(new Car("Ford Fiesta", "Blue", 2011, 50000));
		collection.add(new Car("Ford Focus", "Silver", 2009, 40000));
		collection.add(new Car("Audi A3", "White", 2010, 90000));
		collection.add(new Car("Audi A3", "Black", 2010, 99000));
		collection.add(new Car("Audi A3", "Black", 2010, 100000));
		collection.add(new Car("Audi A3", "Yellow", 2009, 95000));
	}
	
	@Test
	public void testSortAnEmptyCollection() {
		OrderCriteria orderCriteria = new OrderCriteria(new Order("model"));
		List<Car> current = new CollectionSorter<Car>(new HashSet<Car>()).sortBy(orderCriteria);
		
		assertTrue(current.isEmpty());
	}
	
	@Test
	public void testOrderBySingleField() {
		OrderCriteria orderCriteria = new OrderCriteria(new Order("model", SortOrder.DESC));
		collection = new CollectionSorter<Car>(collection).sortBy(orderCriteria);
		
		assertEquals(getItem(0).getModel(), "Ford Focus");
		assertEquals(getItem(1).getModel(), "Ford Fiesta");
		assertEquals(getItem(2).getModel(), "Audi A3");
	}


	
	@Test
	public void testOrderByTwoFields() {
		OrderCriteria orderCriteria = new OrderCriteria(
				new Order("model"),
				new Order("year", SortOrder.DESC)
		);
		
		collection = new CollectionSorter<Car>(collection).sortBy(orderCriteria);
		
		assertEquals(getItem(0).getYear(), 2010);
		assertEquals(getItem(1).getYear(), 2010);
		assertEquals(getItem(2).getYear(), 2010);
		assertEquals(getItem(3).getYear(), 2009);
		assertEquals(getItem(4).getYear(), 2011);
		assertEquals(getItem(5).getYear(), 2009);
	}
	
	@Test
	public void testOrderByThreeFields() {
		OrderCriteria orderCriteria = new OrderCriteria(
				new Order("model"),
				new Order("color"),
				new Order("price")
		);
		
		collection = new CollectionSorter<Car>(collection).sortBy(orderCriteria);
		
		assertEquals(getItem(0).getColor(), "Black");
		assertEquals(getItem(0).getPrice(), 99000);
		
		assertEquals(getItem(1).getColor(), "Black");
		assertEquals(getItem(1).getPrice(), 100000);
		
		assertEquals(getItem(2).getColor(), "White");
	}
	
	@Test
	public void testOrderByThreeFieldsWithStringParametersMethod() {		
		collection = new CollectionSorter<Car>(collection).sortBy("model", "color", "price");
		
		assertEquals(getItem(0).getColor(), "Black");
		assertEquals(getItem(0).getPrice(), 99000);
		
		assertEquals(getItem(1).getColor(), "Black");
		assertEquals(getItem(1).getPrice(), 100000);
		
		assertEquals(getItem(2).getColor(), "White");
	}
	
	@Test
	public void testSimpleCriteria() {
		collection = new CollectionSorter<Car>(collection).sortBy("price");
		
		assertEquals(getItem(5).getPrice(), 100000);
		assertEquals(getItem(4).getPrice(), 99000);
		assertEquals(getItem(3).getPrice(), 95000);
		assertEquals(getItem(2).getPrice(), 90000);
		assertEquals(getItem(1).getPrice(), 50000);
		assertEquals(getItem(0).getPrice(), 40000);
	}
	
	@Test
	public void testSimpleCriteriaDesc() {
		collection = new CollectionSorter<Car>(collection).sortBy("price", SortOrder.DESC);
		
		assertEquals(getItem(0).getPrice(), 100000);
		assertEquals(getItem(1).getPrice(), 99000);
		assertEquals(getItem(2).getPrice(), 95000);
		assertEquals(getItem(3).getPrice(), 90000);
		assertEquals(getItem(4).getPrice(), 50000);
		assertEquals(getItem(5).getPrice(), 40000);
	}
	
	@Test(expected = OrderException.class)
	public void testSanityCheck() {
		OrderCriteria orderCriteria = new OrderCriteria(new Order("inexistentField"));
		new CollectionSorter<Car>(collection).sortBy(orderCriteria);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullCollection() {
		OrderCriteria orderCriteria = new OrderCriteria(new Order("inexistentField"));
		new CollectionSorter<Car>(null).sortBy(orderCriteria);
	}
	
	private Car getItem(int position) {
		return collection.get(position);
	}
	
}

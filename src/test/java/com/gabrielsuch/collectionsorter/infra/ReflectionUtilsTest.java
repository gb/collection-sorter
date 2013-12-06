package com.gabrielsuch.collectionsorter.infra;

import static com.gabrielsuch.collectionsorter.infra.util.ReflectionUtils.classContainsGetter;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gabrielsuch.collectionsorter.domain.testdouble.Car;

public class ReflectionUtilsTest {
	
	@Test
	public void shouldReturnTrueWhenTheGetterIsAvailable() {
		assertTrue(classContainsGetter(Car.class, "model"));
		assertTrue(classContainsGetter(Car.class, "color"));
		assertTrue(classContainsGetter(Car.class, "year"));
		assertTrue(classContainsGetter(Car.class, "price"));
	}
	
	@Test
	public void shouldReturnFalseWhenTheGetterIsNotAvailable() {
		assertFalse(classContainsGetter(Car.class, "fake"));
		assertFalse(classContainsGetter(Car.class, "value"));
	}
	
}

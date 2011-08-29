package com.gabrielsuch.collectionsorter.domain.testdouble;

public class Car {

	private final String model;
	private final String color;
	private final int year;
	private final long price;

	public Car(String model, String color, int year, long price) {
		this.model = model;
		this.color = color;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getYear() {
		return year;
	}

	public long getPrice() {
		return price;
	}

}

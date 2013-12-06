Collection Sorter [![Build Status](https://travis-ci.org/gabrielsuch/collection-sorter.png)](https://travis-ci.org/gabrielsuch/collection-sorter)
===

It's about provide an API to order collections easily in SQL 'order by' style.

Imagine you have a Collection<Car> or any other typed collection.
You want to sort this collection by a specific property.

What you are supposed to do? 
<ol>
<li>Ask to your datasource again?</li>
<li>Implements a lot of different comparator/comparable?</li>
<li>Reinvent the wheel?</li>
</ol>

What about:
```java
new CollectionSorter(yourCollection).sortBy("price");
```

Well, maybe you want it in descending order:
```java
new CollectionSorter(yourCollection).sortBy("price", SortOrder.DESC);
```

Sometimes we've gotta sort by multiple columns:
```java
new CollectionSorter(yourCollection).sortBy("price", "color", "year");
```
or:
```java
OrderCriteria criteria = new OrderCriteria(
     new Order("color"), 
     new Order("year", SortOrder.DESC)
);
	
new CollectionSorter(yourCollection).sortBy(criteria);
```

All right, but now your customer has changed his mind.
He had the brilliant idea of sort by the lowest price.
But still keep the others sorters before it. What you have to do?
``` java
	OrderCriteria criteria = new OrderCriteria(
		new Order("color"), 
		new Order("year", SortOrder.DESC), 
		new Order("price")
	); 
	
	new CollectionSorter(yourCollection).sortBy(criteria);
```

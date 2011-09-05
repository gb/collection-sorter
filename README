*** Collection Sorter

It's about provide an API to order collections easily in SQL 'order by' style.

Imagine you have a Collection<Car> or any other typed collection.
You want to sort this collection by a specific property.

What you are supposed to do?
	1) Ask to your datasource again?
	2) Implements a lot of different comparator/comparable?
	3) Reinvent the wheel?


What about:

	new CollectionSorter(yourCollection).sortBy("price");


Well, maybe you want it in descending order:

	new CollectionSorter(yourCollection).sortBy("price", SortOrder.DESC);


Sometimes we've gotta sort by multiple columns:

	new CollectionSorter(yourCollection).sortBy("price", "color", "year");

or:

	OrderCriteria criteria = new OrderCriteria(
		new Order("color"), 
		new Order("year", SortOrder.DESC)
	);
	
	new CollectionSorter(yourCollection).sortBy(criteria);


All right, but now your customer has changed his mind.
He had the brilliant idea of sort by the lowest price.
But still keep the others sorters before it. What you have to do?

	OrderCriteria criteria = new OrderCriteria(
		new Order("color"), 
		new Order("year", SortOrder.DESC), 
		new Order("price")
	); 
	
	new CollectionSorter(yourCollection).sortBy(criteria);

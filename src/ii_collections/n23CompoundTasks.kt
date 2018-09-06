package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
	return customers.filter { it.orderedProducts.contains(product) }.toSet()
	// Return the set of customers who ordered the specified product
//    todoCollectionTask()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
	// Return the most expensive product among all delivered products
	// (use the Order.isDelivered flag)
	return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
	return customers.flatMap { it.orders.flatMap { order -> order.products } }.filter { it == product }.count()
	// Return the number of times the given product was ordered.
	// Note: a customer may order the same product for several times.
//	todoCollectionTask()
}

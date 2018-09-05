package ii_collections

fun example5() {
	val result = listOf("a", "bbb", "cc").sortedBy { it.length }

	result == listOf("a", "cc", "bbb")
}

fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> {
	return customers.sortedBy { it.orders.size }
	// Return a list of customers, sorted by the ascending number of orders they made
//    todoCollectionTask()
}

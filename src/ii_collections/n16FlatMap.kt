package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered
//    todoCollectionTask()
    return orders.flatMap { it.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    var products = setOf<Product>()
    for (customer in customers) {
        for (order in customer.orders) {
            products+=order.products
        }
    }
    return products
    // Return all products that were ordered by at least one customer
}

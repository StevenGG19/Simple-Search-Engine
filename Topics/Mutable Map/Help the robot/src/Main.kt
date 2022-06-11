fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>): MutableMap<String, Int> {
    val newPurchases = purchases.toMutableMap()
    for ((k, v) in addition) {
        if (purchases.containsKey(k)) {
            newPurchases[k] = v + purchases[k]!!
        } else {
            newPurchases[k] = v
        }
    }
    return newPurchases
}
fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var total = 0
    for (list in shoppingList) {
        if (priceList.containsKey(list)) {
            total += priceList[list]!!
        }
    }
    return total
}
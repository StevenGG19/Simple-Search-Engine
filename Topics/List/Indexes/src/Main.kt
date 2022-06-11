fun solution(products: List<String>, product: String) {
    for (item in products.indices) {
        if (products[item] == product) print("$item ")
    }
}
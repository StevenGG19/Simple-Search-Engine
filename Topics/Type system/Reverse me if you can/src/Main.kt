fun reverse(input: Int?): Int {
    if(input == null) {
        return -1
    }
    val num = input.toString().reversed()
    return num.toInt()
}
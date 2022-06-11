fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
    val newNumbers = numbers.toMutableList()
    newNumbers.add(number)
    return newNumbers
}
fun solution(numbers: List<Int>) {
    val newNumbers = numbers.filter { it % 2 == 0 }
    print(newNumbers.joinToString(" "))
}
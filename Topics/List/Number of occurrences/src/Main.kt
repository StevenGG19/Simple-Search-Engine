fun solution(strings: List<String>, str: String): Int {
    var sum = 0
    for (i in strings) {
        if (i == str) sum++
    }
    return sum
}
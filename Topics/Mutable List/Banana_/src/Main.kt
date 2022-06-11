fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    strings.replaceAll { it.replace(str, "Banana") }
    return strings
}
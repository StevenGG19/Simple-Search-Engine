fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true) {
        val name = readLine()!!
        if (name == "stop") {
            break
        }
        val score = readLine()!!.toInt()
        if (!studentsMarks.containsKey(name)) {
            studentsMarks[name] = score
        }
    }
    print(studentsMarks)
}
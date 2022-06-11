val lambda: (Long, Long) -> Long = lambda@{ a, b ->
    var res: Long = 1
    if (a == b) return@lambda a
    for (i in a..b) {
        res *= i
    }
    res
}
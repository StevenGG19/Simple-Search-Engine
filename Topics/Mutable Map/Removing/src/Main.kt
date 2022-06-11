fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    val newMap = mutableMapOf<Int, String>()
    newMap.putAll(currentMap)
    for ((k, v) in currentMap) {
        if (v == value) newMap.remove(k)
    }
    return newMap
}
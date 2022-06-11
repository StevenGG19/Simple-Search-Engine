package search

import java.io.File

var people = listOf<String>()
val peopleMap = mutableMapOf<String, MutableList<Int>>()
fun main(args: Array<String>) {
    enterPeople(args[1])

    do {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit.")
        val opt = readLine()!!.toInt()
        options(opt)
    } while (opt != 0)
    print("Bye!")
}

fun options(opt: Int) {
    when (opt) {
        1 -> queries()
        2 -> printAll()
        0 -> return
        else -> println("Incorrect option! Try again.")
    }
}

fun printAll() {
    println("=== List of people ===")
    println(people.joinToString("\n"))
}

fun queries() {
    println("Select a matching strategy: ALL, ANY, NONE")
    val matchingStrategy = readLine()!!
    println("Enter a name or email to search all matching people.")
    val find = readLine()!!.lowercase()
    searchOptions(matchingStrategy, find)
}

fun enterPeople(nameFile: String) {
    val file = File(nameFile)
    if (file.exists()) {
        people = file.readLines()
        for ((i, v) in people.withIndex()) {
            v.split(" ").forEach {
                val key = it.lowercase()
                peopleMap.putIfAbsent(key, mutableListOf())
                peopleMap[key]!!.add(i)
            }
        }
    }
}


fun none(find: String) {
    val num = mutableListOf<Int>()
    find.split(" ").forEach {
        if (peopleMap.containsKey(it)) {
            num.addAll(peopleMap.getValue(it))
        }
    }
    if (num.isNotEmpty()) {
        println("${num.size} persons found:")
        for ((i, v) in people.withIndex()) {
            if (!num.contains(i)) {
                println(v)
            }
        }
    } else {
        println("No matching people found.")
    }
}
fun searchOptions(matchingStrategy: String, find: String) {
    when (matchingStrategy) {
        "ALL" -> all(find)
        "ANY" -> any(find)
        "NONE" -> none(find)
    }
}

fun any(find: String) {
    val newFind = find.split(" ")
    val newPeople = mutableListOf<String>()
    newFind.forEach {
        if (peopleMap.containsKey(it)) {
            for (v in peopleMap[it]!!) {
                newPeople.add(people[v])
            }
        }
    }
    if (newPeople.isNotEmpty()) {
        println("${newPeople.size} persons found:")
        println(newPeople.joinToString("\n"))
    } else {
        println("No matching people found.")
    }
}

fun all(find: String) {
    val search = mutableListOf<String>()
    find.split(" ").forEach {
        if (peopleMap.containsKey(it)) {
            for (v in peopleMap[it]!!) {
                search.add(people[v])
            }
        } else {
            println("No matching people found.")
            return
        }
    }
    var index = 1
    for (value in search) {
        for (i in index until search.size) {
            if (value.equals(search[i])) {
                println(search[i])
            }
        }
        index++
    }
}
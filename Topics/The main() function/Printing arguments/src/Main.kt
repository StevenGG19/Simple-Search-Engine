fun main(args: Array<String>) {
    if (args.size == 3) {
        showArguments(args)
    } else {
        println("Invalid number of program arguments")
    }
}

fun showArguments(args: Array<String>) {
    args.forEachIndexed { index, s ->
        println("Argument ${index + 1}: $s. It has ${s.length} characters")
    }
}

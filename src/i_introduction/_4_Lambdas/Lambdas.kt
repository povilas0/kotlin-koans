package i_introduction._4_Lambdas

import util.*

fun example() {

    val sum = { x: Int, y: Int -> x + y }
    val square: (Int) -> Int = { x -> x * x }

    sum(1, square(2)) == 5
}

fun todoTask3(collection: Collection<Int>): Boolean {
    return collection.any { it % 42 == 0 }
}

fun task3(collection: Collection<Int>): Boolean = todoTask3(collection)





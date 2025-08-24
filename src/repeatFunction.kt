
//When a function returns a function or takes a function as an argument, it's called a
// higher-order function.The repeat() function is one such higher-order function.
//The repeat() function is a concise way to express a for loop with functions.

fun main(){
    for (j in 0..10)
        println(j)

    repeat(11){j ->
        println(j)
    }
}
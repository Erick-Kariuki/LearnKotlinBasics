import kotlin.reflect.typeOf

//fun main(){
//    val trickFunction = ::trick
//    trick()
//    trickFunction()
//
//}
//fun trick(){
//    println("No treats!")
//}

//With lambda expressions, you can create variables that store functions, call these
//variables like functions, and store them in other variables that you can call
//like functions.
//fun main(){
//    val trickFunction = trick
//    trick()
//    trickFunction()
//    treat()
//}

fun main(){
//    val coins:(Int) -> String = { quantity ->
//        "$quantity quarters"
//    }
//Write lambda expressions with shorthand syntax. To implement this, we replace
//the 'coins' variable with its shorthand syntax as shown below.

//    val coins:(Int) ->String = {
//        "$it quaters"
//    }

//    val cupcake:(Int) -> String = {
//        "Have a cupcake"
//    }

    //Pass lambda expressions directly into a function. To implement this,
    // we pass the coin lambda expression directly into the function call without
    // having to create the 'coin' variable.

//    val treatFunction = trickOrTreat(false, {"$it quarters"})

    //Using trailing lambda syntax. You can use another shorthand option to write lambdas
    // when a function type is the last parameter of a function. If so, you can place
    // the lambda expression after the closing parenthesis to call the function.
    val treatFunction = trickOrTreat(false) { "$it quarters" }

    val trickFunction = trickOrTreat(true, null)

    //Use 'repeat()' function.
    repeat(4){
        trickFunction()
    }
    treatFunction()

}
fun trickOrTreat(isTrick:Boolean, extraTreat:((Int) -> String)?): () -> Unit{
    if (isTrick)
        return trick
    else
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
}
val trick ={
    println("No treats!")
}
val treat:() -> Unit = {
    println("Have a treat")
}
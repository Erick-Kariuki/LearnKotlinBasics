fun main(){
    var movieName: String = "Straw"
   // movieName = null
    println(movieName)
    println(movieName.length)


    var favouriteCharacter: String? = "Mitchell Lucas"
    println(favouriteCharacter)
    //println(favouriteCharacter.length)
    println(favouriteCharacter?.length)
    println(favouriteCharacter!!.length)
//if...else statement
    if(favouriteCharacter != null) {
        println("The number of characters in your favorite actor's name is ${favouriteCharacter.length}.")
    } else {
        println("You didn't input a name.")
    }
//if/else expression in nullability
    val lengthOfName = if (favouriteCharacter != null) {
        favouriteCharacter.length
    } else {
        0
    }
    println("The number of characters in your favorite actor's name is $lengthOfName.")

//The '?:' Elvis Operator
    val lengthOfName4 = favouriteCharacter?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName4.")

//----------------------------------------------------------------------------------------------
println("--------------------------------------------------------------------------------------")
    favouriteCharacter = null
    println(favouriteCharacter)
    println(favouriteCharacter?.length)
    //println(favouriteCharacter!!.length)
//if...else statement
    if(favouriteCharacter != null) {
        println("The number of characters in your favorite actor's name is ${favouriteCharacter.length}.")
    } else {
        println("You didn't input a name.")
    }

//if/else expression in nullability
    val lengthOfName2 = if (favouriteCharacter != null) {
        favouriteCharacter.length
    } else {
        0
    }
    println("The number of characters in your favorite actor's name is $lengthOfName2.")

//The '?:' Elvis Operator
    val lengthOfName3 = favouriteCharacter?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName3.")
}


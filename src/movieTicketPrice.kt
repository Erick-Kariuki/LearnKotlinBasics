

fun main() {
    val child = 7
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {

    var price : Int

        if (age in 0..13)
            price = 15
        else if (age in 13..60)
            if (isMonday)
                price = 25
            else
                price = 30
        else
            price = 20
    return price

}
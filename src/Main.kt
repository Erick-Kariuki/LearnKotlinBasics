//Conditionals in Kotlin

//1. if ... else statement
fun main() {
    val trafficLightColor = "Red"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }

//2. When statement
    val trafficLightColor2 = "Yellow"

    when (trafficLightColor2) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }

//3. Using if/else and when statements as expressions
    //if/else expression
    val trafficLightColor3 = "Black"
    val message =
        if (trafficLightColor3 == "Red") "Stop"
        else if (trafficLightColor3 == "Yellow") "Slow"
        else if (trafficLightColor3 == "Green") "Go"
        else "Invalid traffic-light color"
    println(message)

    //when expression
        val trafficLightColor4 = "Amber"
        val message2 = when(trafficLightColor4) {
            "Red" -> "Stop"
            "Yellow", "Amber" -> "Slow"
            "Green" -> "Go"
            else -> "Invalid traffic-light color"
        }
        println(message)
}

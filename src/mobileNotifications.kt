fun main(){
    val morningNotifications = 0
    val eveningNotifications = 156

    printNotificationSummary(morningNotifications)
    printNotificationSummary(eveningNotifications)
}

fun printNotificationSummary(numberOfMessages:Int){
    if (numberOfMessages < 100 ){
        println("You have $numberOfMessages notifications")
    }else{
        println("Your phone is blowing up! You have 99+ notifications")
    }
}
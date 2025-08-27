open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded : Boolean = true) : Phone(isScreenLightOn = false){


    override fun switchOn(){
        if (isFolded){
            isScreenLightOn = false
        }
        else{
            isScreenLightOn = true
        }
    }

    fun unfold(){
        isFolded = false
        switchOn()
    }
    fun fold(){
        switchOn()
        isFolded = true
    }

}
fun main(){
    val phone1 = Phone(isScreenLightOn = false)
    phone1.switchOn()
    phone1.checkPhoneScreenLight()
    phone1.switchOff()
    phone1.checkPhoneScreenLight()

    val foldablePhone1 = FoldablePhone(isFolded = true)
    foldablePhone1.switchOn()
    foldablePhone1.checkPhoneScreenLight()
    foldablePhone1.unfold()
    foldablePhone1.checkPhoneScreenLight()
}
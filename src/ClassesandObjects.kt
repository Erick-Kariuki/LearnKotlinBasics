import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


open class SmartDevice (val name:String, val category:String){

    var deviceStatus = "Online"
        protected set

    open val deviceType = "Unknown"

    open fun turnOn(){
        deviceStatus = "On"
    }
    open fun turnOff(){
        deviceStatus = "Off"
    }
    fun printDeviceInfo(){
        println("Device name: $name")
        println("Category: $category")
        println("Type: $deviceType")
    }
}

class SmartTvDevice(deviceName:String, deviceCategory:String) :
    SmartDevice(name = deviceName, category = deviceCategory){

    override val deviceType = "Smart Tv"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(1,0,100)
//    var speakerVolume = 2
//        set(value) {
//            if(speakerVolume in 0..100)
//                field = value
//        }
//    var channelNumber = 1
//        set(value) {
//            if (channelNumber in 0..200)
//                field = value
//        }
    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }
    fun decreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }
    fun nextChannel(){
        channelNumber++
        println("Channel changed to $channelNumber")
    }
    fun previousChannel(){
        channelNumber--
        println("Channel changed to $channelNumber")
    }
    override fun turnOn(){
        //deviceStatus = "On"
        super.turnOn()
        println("$name is turned on.Volume is set to $speakerVolume and " +
                "Channel is set to $channelNumber")
    }
    override fun turnOff(){
        //deviceStatus = "Off"
        super.turnOn()
        println("$name switched off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(deviceName, deviceCategory){

    override val deviceType = "Smart Light"

//    var brightnessLevel = 0
//        set(value) {
//            if (brightnessLevel in 0..100)
//                field = value
//        }

    private var brightnessLevel by RangeRegulator(0,0,100)

    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }
    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness level decreased to $brightnessLevel")
    }
    override fun turnOn(){
        //deviceStatus = "on"
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel")
    }
    override fun turnOff(){
        //deviceStatus = "off"
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off.")
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int): ReadWriteProperty<Any?, Int>{

        var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue){
            fieldData = value
        }
    }

}

class SmartHome (
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice: SmartLightDevice)
{
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv(){
        smartTvDevice.turnOn()
        deviceTurnOnCount++
    }
    fun turnOffTv(){
        smartTvDevice.turnOff()
        deviceTurnOnCount--
    }
    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }
    fun decreaseTvVolume(){
        smartTvDevice.decreaseSpeakerVolume()
    }
    fun changeChannelToNext(){
        smartTvDevice.nextChannel()
    }
    fun changeChannelToPrevious(){
        smartTvDevice.previousChannel()
    }
    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }

    fun turnOnLight(){
        smartLightDevice.turnOn()
        deviceTurnOnCount++
    }
    fun turnOffLight(){
        smartLightDevice.turnOff()
        deviceTurnOnCount--
    }
    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }
    fun decreaseLightBrightness(){
        smartLightDevice.decreaseBrightness()
    }
    fun printSmartLightInfo(){
        smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices(){
        smartTvDevice.turnOff()
        smartLightDevice.turnOff()
    }

}

fun main(){
    var smartDevice:SmartDevice = SmartTvDevice(deviceName = "Android Tv", deviceCategory = "Entertainment")
    smartDevice.turnOn()


    var smartDevice2 =  SmartLightDevice("Google Light", "Utility")
    smartDevice2.turnOn()


    var smartHome = SmartHome(smartDevice as SmartTvDevice, smartDevice2)
    smartHome.turnOnTv()
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    smartHome.turnOffAllDevices()
    smartHome.increaseTvVolume()

}
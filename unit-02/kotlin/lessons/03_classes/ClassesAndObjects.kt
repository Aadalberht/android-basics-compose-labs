open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "offline"
        protected set

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(name: String, category: String) : SmartDevice(name, category) {
    var speakerVolume = 2
        private set
    var channelNumber = 1
        private set

    fun increaseSpeakerVolume() {
        if (deviceStatus == "on") speakerVolume++
    }

    fun nextChannel() {
        if (deviceStatus == "on") channelNumber++
    }
}

class SmartLightDevice(name: String, category: String) : SmartDevice(name, category) {
    var brightnessLevel = 0
        private set

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
    }

    fun increaseBrightness() {
        if (deviceStatus == "on") brightnessLevel++
    }
}

class SmartHome(
    private val smartTvDevice: SmartTvDevice,
    private val smartLightDevice: SmartLightDevice
) {
    val deviceTurnOnCount: Int
        get() = listOf(smartTvDevice, smartLightDevice).count { it.deviceStatus == "on" }

    fun turnOnTv() = smartTvDevice.turnOn()
    fun turnOnLight() = smartLightDevice.turnOn()
}

fun main() {
    val tv = SmartTvDevice("Android TV", "Entertainment")
    val light = SmartLightDevice("Google Light", "Utility")
    val home = SmartHome(tv, light)

    home.turnOnTv()
    tv.increaseSpeakerVolume()
    tv.nextChannel()
    home.turnOnLight()
    light.increaseBrightness()

    println("TV: ${tv.deviceStatus}, volume ${tv.speakerVolume}, channel ${tv.channelNumber}")
    println("Light: ${light.deviceStatus}, brightness ${light.brightnessLevel}")
    println("Devices turned on: ${home.deviceTurnOnCount}")
}

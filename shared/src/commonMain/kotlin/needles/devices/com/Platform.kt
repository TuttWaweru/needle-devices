package needles.devices.com

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
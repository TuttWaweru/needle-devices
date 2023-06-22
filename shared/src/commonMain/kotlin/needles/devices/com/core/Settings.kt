package needles.devices.com.core

class Settings(val defaultFeedUrls: Set<String>) {
    fun isDefault(feedUrl: String) = defaultFeedUrls.contains(feedUrl)
}
package needle.devices.com.settings

interface NeedleKeyValueStorage {
    var token: String?
    // val observableToken: Flow<String>
    fun cleanStorage()
}
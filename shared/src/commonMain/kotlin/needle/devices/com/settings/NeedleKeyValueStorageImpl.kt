package needle.devices.com.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import needle.devices.com.utils.NeedleStorageKeys
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

// link: https://blog.protein.tech/kotlin-multiplatform-the-ultimate-guide-to-key-value-storage-ded5cc17cd42?gi=d6abca22a6dd
class NeedleKeyValueStorageImpl(/*private val settings: Settings*/) : NeedleKeyValueStorage, KoinComponent {
//     private val settings: Settings by lazy { Settings }
     private val settings: Settings by inject()
    // private val observableSettings: ObservableSettings by lazy { settings as ObservableSettings }

    /*operator fun getValue(thisRef: NeedleKeyValueStorageImpl, property: KProperty<*>): Settings {
        return settings
    }*/

    override var token: String?
        get() = settings[NeedleStorageKeys.TOKEN.key]
        set(value) {
            settings[NeedleStorageKeys.TOKEN.key] = value
        }

    /*override val observableToken: Flow<String>
        get() = observableSettings.getStringFlow(NeedleStorageKeys.TOKEN.key, "")*/

    override fun cleanStorage() {
        settings.clear()
    }
}

package needles.devices.com.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class NeedlesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
//        if (BuildConfig.DEBUG) {
        Timber.plant(Timber.DebugTree())
//        }
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(androidContext = this@NeedlesApp)
            modules(modules = emptyList())
        }
    }
}

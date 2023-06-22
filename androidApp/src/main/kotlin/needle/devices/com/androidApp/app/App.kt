package needle.devices.com.androidApp.app

import android.app.Application
import needle.devices.com.androidApp.BuildConfig
import needle.devices.com.androidApp.di.appModules
import needle.devices.com.androidApp.utils.sync.RefreshWorker
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        launchBackgroundSync()
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.INFO)

            androidContext(this@App)
            modules(appModules)
        }
    }

    private fun launchBackgroundSync() {
        RefreshWorker.enqueue(this)
    }
}
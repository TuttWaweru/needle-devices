package needle.devices.com.androidApp.app

import android.app.Application
import needle.devices.com.androidApp.BuildConfig
import needle.devices.com.androidApp.utils.sync.RefreshWorker
import needle.devices.com.app.FeedStore
import needle.devices.com.core.RssReader
import needle.devices.com.core.create
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        launchBackgroundSync()
    }

    private val appModule = module {
        single { RssReader.create(get(), BuildConfig.DEBUG) }
        single { FeedStore(get()) }
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.ERROR)

            androidContext(this@App)
            modules(appModule)
        }
    }

    private fun launchBackgroundSync() {
        RefreshWorker.enqueue(this)
    }
}
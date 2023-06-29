package needle.devices.com.androidApp.app

import android.app.Application
import androidx.annotation.Nullable
import needle.devices.com.androidApp.BuildConfig
import needle.devices.com.androidApp.di.appModules
import needle.devices.com.androidApp.utils.sync.RefreshWorker
import needle.devices.com.core.di.androidModule
import needle.devices.com.di.commonApiModule
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        setupTimber()
        launchBackgroundSync()
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.INFO)

            androidContext(this@App)
            val modules = mutableListOf<Module>().apply {
                addAll(appModules)
                addAll(commonApiModule)
                addAll(androidModule)
            }
            modules(modules)
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.methodName + ":" + element.lineNumber
                }
            })
        }
    }

    private fun launchBackgroundSync() {
        RefreshWorker.enqueue(this)
    }
}
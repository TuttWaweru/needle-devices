package needle.devices.com.androidApp.di

import com.google.i18n.phonenumbers.PhoneNumberUtil
import needle.devices.com.androidApp.BuildConfig
import needle.devices.com.androidApp.app.AppActivityViewModel
import needle.devices.com.androidApp.composeui.screens.viewmodels.LoginScreenViewModel
import needle.devices.com.androidApp.composeui.screens.viewmodels.OtpScreenViewModel
import needle.devices.com.androidApp.composeui.screens.viewmodels.RegisterScreenViewModel
import needle.devices.com.app.FeedStore
import needle.devices.com.core.RssReader
import needle.devices.com.core.create
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {
    single { RssReader.create(get(), BuildConfig.DEBUG) }
    single { FeedStore(get()) }
}

val viewmodelModule: Module = module {
    viewModel { AppActivityViewModel() }
    viewModel { LoginScreenViewModel() }
    viewModel { OtpScreenViewModel() }
    viewModel { RegisterScreenViewModel() }
}

val utilModule: Module = module {
    single { PhoneNumberUtil.getInstance() }
}

val appModules: List<Module> = listOf(
    dataModule,
    viewmodelModule,
    utilModule,
)
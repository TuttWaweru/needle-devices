package needle.devices.com.androidApp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.filterIsInstance
import needle.devices.com.androidApp.composeui.screens.onboarding.WelcomeOneScreen
import needle.devices.com.androidApp.composeui.theme.AppTheme
import needle.devices.com.app.FeedSideEffect
import needle.devices.com.app.FeedStore
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class AppActivity : ComponentActivity() {

    private val viewModel: AppActivityViewModel by viewModel()

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val store: FeedStore by inject()
                val snackbarHostState = remember { SnackbarHostState() }
                val error = store.observeSideEffect()
                    .filterIsInstance<FeedSideEffect.Error>()
                    .collectAsState(null)
                val uiState = viewModel.uiState.collectAsStateWithLifecycle()

                LaunchedEffect(error.value) {
                    error.value?.let {
                        snackbarHostState.showSnackbar(
                            it.error.message.toString()
                        )
                    }
                }

                Box(
                    Modifier.padding(
                        WindowInsets.systemBars
                            .only(WindowInsetsSides.Start + WindowInsetsSides.End)
                            .asPaddingValues()
                    )
                ) {
                    Scaffold(
                        snackbarHost = {
                            SnackbarHost(
                                hostState = snackbarHostState,
                                modifier = Modifier.padding(
                                    WindowInsets.systemBars
                                        .only(WindowInsetsSides.Bottom)
                                        .asPaddingValues()
                                )
                            )
                        }
                    ) { paddingValues ->
                        // Navigator(MainScreen())
                        val padding = paddingValues
                        Navigator(
                            WelcomeOneScreen()
                        )
                    }
                }
            }
        }
    }
}

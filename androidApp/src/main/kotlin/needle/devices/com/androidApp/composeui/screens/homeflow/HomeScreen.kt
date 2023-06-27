package needle.devices.com.androidApp.composeui.screens.homeflow

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import needle.devices.com.androidApp.composeui.theme.Padding
import org.koin.core.component.KoinComponent

class HomeScreen : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow

        HomeScreenContent(
            context = context,
            navigator = navigator,
        )
    }

}

@Composable
private fun HomeScreenContent(
    context: Context,
    navigator: Navigator,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.Normal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Home Screen",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
private fun HomeScreenContentPreview() {
    HomeScreenContent(
        context = LocalContext.current,
        navigator = LocalNavigator.currentOrThrow
    )
}
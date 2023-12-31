package needle.devices.com.androidApp.composeui.screens.auth

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import needle.devices.com.androidApp.R
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import org.koin.core.component.KoinComponent

@Composable
fun RegisterScreenRoute() {
    // RegisterScreen()
}

class ScreenRegister : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow

        RegisterScreen(context = context, navigator = navigator)
    }

}

@Composable
fun RegisterScreen(
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
            text = "Register Screen",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        Button(
            modifier = Modifier,
            onClick = {
                navigator.push(ScreenLogin())
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.login),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
private fun RegisterScreenPreview() {
    RegisterScreen(
        context = LocalContext.current,
        navigator = LocalNavigator.currentOrThrow
    )
}
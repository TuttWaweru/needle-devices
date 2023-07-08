package needle.devices.com.androidApp.composeui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import needle.devices.com.androidApp.R
import needle.devices.com.androidApp.composeui.components.NeedleTopBar
import needle.devices.com.androidApp.composeui.screens.homeflow.HomeScreen
import needle.devices.com.androidApp.composeui.screens.viewmodels.OtpScreenViewModel
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import org.koin.core.component.KoinComponent

class OtpScreen : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: OtpScreenViewModel = viewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        Otp(
            onBackButtonClick = { navigator.pop() },
            onNeedleIconClick = {},
            onClickLoginButton = { navigator.push(ScreenRegister()) }
        )
    }
}

@Composable
private fun Otp(
    onBackButtonClick: () -> Unit = {},
    onNeedleIconClick: () -> Unit = {},
    onClickLoginButton: () -> Unit = {},
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.Normal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        NeedleTopBar(onBackButtonClick = { onBackButtonClick() }, onNeedleIconClick = { onNeedleIconClick() })

        Spacer(modifier = Modifier.height(Height.Normal))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Otp Screen",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Height.Large))

        IconButton(
            modifier = Modifier
                .padding(top = Padding.ExtraLarge)
                .size(64.dp)
                .background(shape = CircleShape, color = MaterialTheme.colorScheme.primary),
            colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onPrimary),
            onClick = {
                onClickLoginButton()
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = stringResource(id = R.string.login),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Padding.XsSmall)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OtpPreview() {
    Otp()
}
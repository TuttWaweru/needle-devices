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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import needle.devices.com.androidApp.R
import needle.devices.com.androidApp.composeui.components.NeedleTopBar
import needle.devices.com.androidApp.composeui.components.OutlinedOtpTextField
import needle.devices.com.androidApp.composeui.screens.viewmodels.OtpScreenViewModel
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import org.koin.core.component.KoinComponent
import timber.log.Timber

data class OtpScreen(
    val phoneNumber: String
) : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: OtpScreenViewModel = viewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
        val context = LocalContext.current

        Otp(
            onBackButtonClick = { navigator.pop() },
            onNeedleIconClick = {},
            onClickLoginButton = {
                if (uiState.otp.length != 4 || uiState.otp.isBlank()) {
                    Timber.i("** Invalid Otp")
                } else {
                    navigator.push(ScreenRegister())
                }
            },
            otp = uiState.otp,
            updateOtp = { newOtp: String ->
                Timber.i("** newOtp: $newOtp")
                viewModel.updateOtp(value = newOtp)
            },
            phoneNumber = phoneNumber
        )
    }
}

@Composable
private fun Otp(
    onBackButtonClick: () -> Unit = {},
    onNeedleIconClick: () -> Unit = {},
    onClickLoginButton: () -> Unit = {},
    otp: String,
    updateOtp: (String) -> Unit,
    phoneNumber: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.Normal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        NeedleTopBar(
            onBackButtonClick = { onBackButtonClick() },
            onNeedleIconClick = { onNeedleIconClick() })

        Spacer(modifier = Modifier.height(Height.Normal))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.verification),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.outline,
            )
            Spacer(modifier = Modifier.height(Height.Medium))
            Text(
                text = stringResource(id = R.string.sent_sms_with_code),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(Height.Medium))
            Text(
                text = stringResource(id = R.string.to_the_number, phoneNumber),
                modifier = Modifier.fillMaxWidth(),
            )
        }

        Spacer(modifier = Modifier.height(Height.Large))

        OutlinedOtpTextField(
            modifier = Modifier,
            value = otp,
            onValueChange = {
                updateOtp(it)
            },
            length = 4,
            onFilled = {},
            errorMessage = null,
            helperText = null,
            enabled = true,
            readOnly = false,
            requestFocus = true,
            clearFocusWhenFilled = true
        )

        Spacer(modifier = Modifier.height(Height.Small))

        Text(
            text = stringResource(id = R.string.code_not_arrived),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.height(Height.FortyEight))

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
        Text(text = stringResource(id = R.string.next))
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OtpPreview() {
    Otp(
        otp = "1234",
        updateOtp = {},
        phoneNumber = stringResource(id = R.string.sample_ke_number)
    )
}
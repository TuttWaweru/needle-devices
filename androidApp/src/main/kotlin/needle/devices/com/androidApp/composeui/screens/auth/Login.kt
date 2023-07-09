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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import needle.devices.com.androidApp.composeui.screens.viewmodels.LoginScreenViewModel
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import needle.devices.com.androidApp.utils.showToast
import org.koin.core.component.KoinComponent

class ScreenLogin : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: LoginScreenViewModel = viewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        LoginScreen(
            onBackButtonClick = { navigator.pop() },
            phoneNumber = uiState.phoneNumber,
            updatePhoneNumber = { phoneNumber ->
                viewModel.updatePhoneNumber(phoneNumber)
            },
            onClickLogin = {
                if (uiState.phoneNumber.isBlank()) {
                    context.showToast(context.resources.getString(R.string.invalid_phone_number))
                } else {
                    navigator.push(OtpScreen(phoneNumber = uiState.phoneNumber))
                }
            }
        )
    }
}

@Composable
private fun LoginScreen(
    onBackButtonClick: () -> Unit,
    phoneNumber: String,
    updatePhoneNumber: (String) -> Unit,
    onClickLogin: () -> Unit,
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
            onNeedleIconClick = {}
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.login_and_registration),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.outline,
            )
            Spacer(modifier = Modifier.height(Height.Medium))
            Text(
                text = stringResource(id = R.string.give_me_your_number),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
            )
        }

        Spacer(modifier = Modifier.height(Height.ExtraLarge))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phoneNumber,
            onValueChange = { updatePhoneNumber(it) },
            shape = RoundedCornerShape(24.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        /*MaterialCountryCodePicker()
        TogiCountryCodePicker(
            text = uiState.phoneNumber,
            onValueChange = { viewModel.updatePhoneNumber(it) },
            unfocusedBorderColor = MaterialTheme.colorScheme.primary,
            bottomStyle =false, //  if true the text-field is below the country code selector at the top.
            shape = RoundedCornerShape(24.dp)
        )*/

        Spacer(modifier = Modifier.height(Height.ExtraLarge))

        IconButton(
            modifier = Modifier
                .padding(top = Padding.ExtraLarge)
                .size(64.dp)
                .background(shape = CircleShape, color = MaterialTheme.colorScheme.primary),
            colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onPrimary),
            onClick = { onClickLogin() }
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
private fun LoginScreenPreview() {
    LoginScreen(
        onBackButtonClick = {},
        phoneNumber = "",
        updatePhoneNumber = {},
        onClickLogin = {},
    )
}
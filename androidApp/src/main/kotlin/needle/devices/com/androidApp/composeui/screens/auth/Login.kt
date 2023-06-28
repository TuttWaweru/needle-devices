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
import androidx.compose.ui.text.input.KeyboardType
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
import needle.devices.com.androidApp.composeui.screens.viewmodels.LoginScreenViewModel
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import org.koin.core.component.KoinComponent

class ScreenLogin : Screen, KoinComponent {
    @Composable
    override fun Content() {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val navigator = LocalNavigator.currentOrThrow
    val viewModel: LoginScreenViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.Normal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        NeedleTopBar(onBackButtonClick = { navigator.pop() }, onNeedleIconClick = {})

        Spacer(modifier = Modifier.height(Height.Normal))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Login Screen",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Height.Large))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.phoneNumber,
            onValueChange = { viewModel.updatePhoneNumber(it) },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        /*TogiCountryCodePicker(
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
            onClick = {
                viewModel.initEventLogin()
                // navigator.push(HomeScreen())
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
@Preview
private fun LoginScreenPreview() {
    LoginScreen()
}
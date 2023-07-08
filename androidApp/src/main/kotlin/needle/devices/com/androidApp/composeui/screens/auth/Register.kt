package needle.devices.com.androidApp.composeui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import needle.devices.com.androidApp.R
import needle.devices.com.androidApp.composeui.screens.homeflow.HomeScreen
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import needle.devices.com.androidApp.utils.showToast
import org.koin.core.component.KoinComponent

class ScreenRegister : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow

        RegisterScreen(
            onClickRegisterButton = { navigator.push(HomeScreen()) },
            onClickAddPhoto = {
                context.showToast(message = "Add Photo")
            },
        )
    }

}

@Composable
fun RegisterScreen(
    onClickRegisterButton: () -> Unit,
    onClickAddPhoto: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.Normal),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(Height.ExtraLarge))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.create_a_profile),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(Padding.Medium)
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape
                )
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .clickable { onClickAddPhoto() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_user_blueish),
                contentDescription = "Add Photo Image",
                modifier = Modifier.size(72.dp),
            )
            Spacer(modifier = Modifier.height(Height.Small))
            Text(
                text = stringResource(id = R.string.add_your_photo),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = Padding.Large),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(Height.Normal))

        Text(
            text = stringResource(id = R.string.name_or_company_name),
            modifier = Modifier.fillMaxWidth().padding(start = Padding.Small),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(Height.Small))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp)
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        Text(
            text = stringResource(id = R.string.address),
            modifier = Modifier.fillMaxWidth().padding(start = Padding.Small),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(Height.Small))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp)
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        Text(
            text = stringResource(id = R.string.profile_description),
            modifier = Modifier.fillMaxWidth().padding(start = Padding.Small),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(Height.Small))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 100.dp),
            shape = RoundedCornerShape(24.dp),
            singleLine = false,
        )


        Spacer(modifier = Modifier.height(Height.FortyEight))
        Button(
            modifier = Modifier,
            onClick = {
                onClickRegisterButton()
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_continue),
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun RegisterScreenPreview() {
    RegisterScreen(onClickRegisterButton = {}, onClickAddPhoto = {})
}
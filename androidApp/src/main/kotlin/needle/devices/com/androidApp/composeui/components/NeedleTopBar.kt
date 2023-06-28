package needle.devices.com.androidApp.composeui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import needle.devices.com.androidApp.R
import needle.devices.com.androidApp.composeui.theme.Padding

@Composable
internal fun NeedleTopBar(
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit,
    onNeedleIconClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = Padding.Normal,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            modifier = Modifier
                .background(shape = CircleShape, color = MaterialTheme.colorScheme.primary),
            colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onPrimary),
            onClick = { onBackButtonClick() }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Button",
                modifier = Modifier
                    .fillMaxSize()
                    .size(24.dp)
                    .padding(Padding.XsSmall)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.needle_icon_large),
            contentDescription = "Needle icon",
            modifier = Modifier
                .size(52.dp)
                .background(color = Color.Transparent, shape = CircleShape)
                .clickable { onNeedleIconClick() },
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
@Preview
private fun NeedleTopBarPreview() {
    NeedleTopBar(
        onBackButtonClick = {},
        onNeedleIconClick = {}
    )
}
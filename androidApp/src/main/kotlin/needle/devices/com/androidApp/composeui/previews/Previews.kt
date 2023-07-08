package needle.devices.com.androidApp.composeui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import needle.devices.com.androidApp.composeui.components.PostItem
import needle.devices.com.androidApp.composeui.components.FeedIcon
import needle.devices.com.androidApp.composeui.components.FeedItem
import needle.devices.com.androidApp.composeui.theme.AppTheme
import needle.devices.com.core.entity.Feed
import needle.devices.com.core.entity.Post

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedItemPreview() {
    AppTheme {
        FeedItem(feed = PreviewData.feed) {}
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PostPreview() {
    AppTheme {
        PostItem(item = PreviewData.post, onClick = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedIconPreview() {
    AppTheme {
        FeedIcon(feed = PreviewData.feed)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedIconSelectedPreview() {
    AppTheme {
        FeedIcon(feed = PreviewData.feed, true)
    }
}

private object PreviewData {
    val post = Post(
        title = "Productive Server-Side Development With Kotlin: Stories From The Industry",
        desc = "Kotlin was created as an alternative to Java, meaning that its application area within the JVM ecosystem was meant to be the same as Java’s. Obviously, this includes server-side development. We would love...",
        imageUrl = "https://blog.jetbrains.com/wp-content/uploads/2020/11/server.png",
        link = "https://blog.jetbrains.com/kotlin/2020/11/productive-server-side-development-with-kotlin-stories/",
        date = 42L
    )
    val feed = Feed(
        title = "Kotlin Blog",
        link = "blog.jetbrains.com/kotlin/",
        desc = "blog.jetbrains.com/kotlin/",
        imageUrl = null,
        posts = listOf(post),
        sourceUrl = "https://blog.jetbrains.com/feed/",
        isDefault = true
    )
}

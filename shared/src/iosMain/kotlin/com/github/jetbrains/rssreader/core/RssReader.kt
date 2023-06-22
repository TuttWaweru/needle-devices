package com.github.jetbrains.rssreader.core

import needles.devices.com.core.datasource.network.FeedLoader
import needles.devices.com.core.datasource.storage.FeedStorage
import com.russhwolf.settings.NSUserDefaultsSettings
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.serialization.json.Json
import needles.devices.com.core.RssReader
import platform.Foundation.NSUserDefaults

fun RssReader.Companion.create(withLog: Boolean) = RssReader(
    FeedLoader(
        IosHttpClient(withLog),
        IosFeedParser()
    ),
    FeedStorage(
        NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults()),
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    )
).also {
    if (withLog) Napier.base(DebugAntilog())
}
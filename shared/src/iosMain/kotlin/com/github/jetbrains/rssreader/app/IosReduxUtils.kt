package com.github.jetbrains.rssreader.app

import com.github.jetbrains.rssreader.core.wrap
import needles.devices.com.app.FeedStore

fun FeedStore.watchState() = observeState().wrap()
fun FeedStore.watchSideEffect() = observeSideEffect().wrap()
/*
 * Copyright 2023 Needle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package needle.devices.com.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Network representation of [Menu]
 */
@Serializable
data class MenusResponse(@SerialName("items") val items: List<NetworkMenu> = emptyList())

@Serializable
data class NetworkMenu(
    @SerialName("id") val menuId: String? = null,
    @SerialName("logo")
    val logo: String? = null,
    @SerialName("name")
    val name: String,
    @SerialName("sort")
    val sort: Int,
    @SerialName("label")
    val label: String? = null,
    @SerialName("event_id") val eventId: String? = null,
    @SerialName("label_icon")
    val label_icon: String? = null,
    @SerialName("item_background_color")
    val item_background_color: String? = null,
    @SerialName("item_foreground_color")
    val item_foreground_color: String? = null,
    @SerialName("menu_background_color")
    val menu_background_color: String? = null,
    @SerialName("menu_alternate_color")
    val menu_alternate_color: String? = null,
    @SerialName("menu_background_image")
    val menu_background_image: String? = null,
    @SerialName("menu_foreground_color")
    val menu_foreground_color: String? = null,
    @SerialName("screen_background_color")
    val screen_background_color: String? = null,
    @SerialName("detail_item_background_color")
    val detail_item_background_color: String? = null,
    @SerialName("detail_item_foreground_color")
    val detail_item_foreground_color: String? = null,
    @SerialName("active")
    val active: Boolean? = true,
)

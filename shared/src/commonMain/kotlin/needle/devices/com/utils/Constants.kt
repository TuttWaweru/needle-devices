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

package needle.devices.com.utils

object Constants {
    const val BASE_URL = "https://c431-197-237-149-186.ngrok-free.app"
    const val SAMPLE_URL = "http://197.248.68.161/server/public/api/v1/"
}
enum class NeedleStorageKeys {
    TOKEN;
    val key get() = this.name
}

package needle.devices.com.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val username: String,
)

@Serializable
data class LoginResponse(
    val success: Boolean? = null
)
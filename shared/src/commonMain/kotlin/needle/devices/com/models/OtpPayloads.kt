package needle.devices.com.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtpRequest(
    @SerialName("phone_number") val phoneNumber: String,
)

@Serializable
data class OtpResponse(
    val success: Boolean? = null
)

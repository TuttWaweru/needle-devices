package needle.devices.com.androidApp.models

data class LoginScreenUiState(
    val loading: Boolean = false,
    val phoneNumber: String = "",
    val countryCode: String = "", // eg +254
)

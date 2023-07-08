package needle.devices.com.androidApp.models

data class RegisterScreenUiState(
    val registerInput: RegisterScreenInputs = RegisterScreenInputs(),
    val error: String = "",
    val name: String = "",
    val address: String = "",
    val profileDescription: String = "",
)

data class RegisterScreenInputs(
    val name: String = "",
    val address: String = "",
    val profileDescription: String = "",
)

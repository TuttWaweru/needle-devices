package needle.devices.com.androidApp.composeui.screens.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import needle.devices.com.androidApp.models.OtpScreenUiState

class OtpScreenViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<OtpScreenUiState> = MutableStateFlow(OtpScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun updateOtp(value: String) = _uiState.update {
        it.copy(otp = value)
    }
    fun updatePhoneNumber(value: String) = _uiState.update {
        it.copy(phoneNumber = value)
    }
}
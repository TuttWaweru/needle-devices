package needle.devices.com.androidApp.composeui.screens.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import needle.devices.com.androidApp.models.LoginScreenUiState

class LoginScreenViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<LoginScreenUiState> = MutableStateFlow(LoginScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun updatePhoneNumber(value: String) = _uiState.update {
        it.copy(phoneNumber = value)
    }

    fun updateLoading(value: Boolean) = _uiState.update {
        it.copy(loading = value)
    }
}
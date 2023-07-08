package needle.devices.com.androidApp.composeui.screens.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import needle.devices.com.androidApp.models.RegisterScreenUiState

class RegisterScreenViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<RegisterScreenUiState> = MutableStateFlow(RegisterScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun updateName(value: String) = _uiState.update {state ->
        state.copy(
            name = value
        )
    }
    fun updateAddress(value: String) = _uiState.update {state ->
        state.copy(
            address = value
        )
    }
    fun updateProfileDescription(value: String) = _uiState.update {state ->
        state.copy(
            profileDescription = value
        )
    }
}
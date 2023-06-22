package needle.devices.com.androidApp.app

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import needle.devices.com.androidApp.models.AppActivityUiState

class AppActivityViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<AppActivityUiState> = MutableStateFlow(AppActivityUiState())
    val uiState = _uiState.asStateFlow()

}
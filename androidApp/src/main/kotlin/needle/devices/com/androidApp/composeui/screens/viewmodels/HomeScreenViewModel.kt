package needle.devices.com.androidApp.composeui.screens.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import needle.devices.com.androidApp.models.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun updateSearchQuery(value: String) = _uiState.update {
        it.copy(
            searchQuery = value
        )
    }

    fun updateIsSeachBarActive(value: Boolean) = _uiState.update {
        it.copy(isSeachBarActive = value)
    }

    fun updateSearchResults(value: List<String>) = _uiState.update {
        it.copy(searchResults = value)
    }
}
package needle.devices.com.androidApp.composeui.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import needle.devices.com.androidApp.models.HomeScreenUiState
import timber.log.Timber

class HomeScreenViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun updateSearchQuery(value: String) = _uiState.update {
        it.copy(
            searchQuery = value
        )
    }

    fun initializeSearch(value: String) = viewModelScope.launch {
        val currentUiStateSearchQuery = _uiState.value.searchQuery
        Timber.i("** initializing search of query[ $value ], current uiState.searchQuery[ $currentUiStateSearchQuery ]")
        if (value.isBlank()) {
            updateError(value = "Query cannot be empty")
        } else if (value != currentUiStateSearchQuery) {
            updateError(value = "Error with query, $value!")
        } else {
            Timber.i("** making search of query[ $value ]")
        }
    }

    fun updateShowSearchResults(value: Boolean) = _uiState.update {
        it.copy(showSearchResults = value)
    }

    fun updateSearchResults(value: List<String>) = _uiState.update {
        it.copy(searchResults = value)
    }

    private fun updateError(value: String) {
        if (value.isNotBlank()) {
            Timber.i("** updating error[ $value ]")
            _uiState.update {
                it.copy(error = value)
            }
        }
    }
}
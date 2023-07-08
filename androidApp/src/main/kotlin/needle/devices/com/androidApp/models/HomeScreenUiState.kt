package needle.devices.com.androidApp.models

data class HomeScreenUiState(
    val searchQuery: String = "",
    val showSearchResults: Boolean = false,
    val searchResults: List<String> = emptyList(),
    val error: String = "",
)

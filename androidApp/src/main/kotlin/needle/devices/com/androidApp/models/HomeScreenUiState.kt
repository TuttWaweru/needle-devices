package needle.devices.com.androidApp.models

data class HomeScreenUiState(
    val searchQuery: String = "",
    val isSeachBarActive: Boolean = true,
    val searchResults: List<String> = emptyList(),
)

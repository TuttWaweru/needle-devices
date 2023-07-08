package needle.devices.com.androidApp.composeui.screens.homeflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import needle.devices.com.androidApp.R
import needle.devices.com.androidApp.composeui.components.NeedleTopBar
import needle.devices.com.androidApp.composeui.screens.viewmodels.HomeScreenViewModel
import needle.devices.com.androidApp.composeui.theme.Height
import needle.devices.com.androidApp.composeui.theme.Padding
import org.koin.core.component.KoinComponent
import timber.log.Timber

class HomeScreen : Screen, KoinComponent {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: HomeScreenViewModel = viewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        HomeScreenContent(
            onBackButtonClick = { navigator.popAll() },
            searchQuery = uiState.searchQuery,
            updatesearchQuery = { newQuery: String -> viewModel.updateSearchQuery(value = newQuery) },
            isSearchActive = uiState.isSeachBarActive,
            searchResults = uiState.searchResults,
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenContent(
    onBackButtonClick: () -> Unit,
    searchQuery: String,
    updatesearchQuery: (String) -> Unit,
    isSearchActive: Boolean,
    searchResults: List<String>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.Normal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        NeedleTopBar(
            onBackButtonClick = { onBackButtonClick() },
            onNeedleIconClick = {}
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.explore),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(Height.Small))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.find_unique_equipment_for),
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(Height.Normal))

        SearchBar(
            query = searchQuery,
            onQueryChange = { newQuery: String -> updatesearchQuery(newQuery) },
            onSearch = { newSearch: String -> updatesearchQuery(newSearch) },
            active = isSearchActive,
            onActiveChange = { isActive: Boolean -> Timber.i("** search-bar is $isActive") },
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Row {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id = R.string.content_description_home_searchbar),
                        modifier = Modifier,
                    )
                    Spacer(modifier = Modifier.width(Height.XsSmall))
                    Text(
                        text = stringResource(id = R.string.search),
                        modifier = Modifier,
                    )
                }
            },
            placeholder = {}
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(Padding.Normal),
                verticalArrangement = Arrangement.spacedBy(Padding.XsSmall)
            ) {
                itemsIndexed(searchResults) { index: Int, item: String ->
                    ListItem(
                        headlineContent = { /*TODO*/ },
                        supportingContent = { Text("Additional info") },
                        leadingContent = {
                            Icon(
                                Icons.Filled.Star,
                                contentDescription = "search result leading icon"
                            )
                        },
                        modifier = Modifier,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(Height.Normal))

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HomeScreenContentPreview() {
    HomeScreenContent(
        onBackButtonClick = {},
        searchQuery = "search",
        updatesearchQuery = {},
        isSearchActive = true,
        searchResults = emptyList()
    )
}
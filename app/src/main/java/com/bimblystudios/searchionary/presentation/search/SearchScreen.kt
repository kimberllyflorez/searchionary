package com.bimblystudios.searchionary.presentation.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bimblystudios.searchionary.data.model.Meaning
import com.bimblystudios.searchionary.data.model.Word
import com.bimblystudios.searchionary.data.model.sample.WordSample
import com.bimblystudios.searchionary.presentation.common.UiStatus
import com.bimblystudios.searchionary.presentation.ui.components.AudioPlayer
import com.bimblystudios.searchionary.presentation.ui.components.EmptyState
import com.bimblystudios.searchionary.presentation.ui.components.ErrorState
import com.bimblystudios.searchionary.presentation.ui.components.LoadingIndicator
import com.bimblystudios.searchionary.presentation.ui.theme.SearchionaryTheme

@Composable
fun SearchScreen(viewModel: SearchViewModel, modifier: Modifier = Modifier) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    SearchScreen(
        modifier = modifier,
        searchQuery = state.searchQuery,
        searchResults = state.searchResults,
        status = state.status,
        onSearchQueryChange = {
            viewModel.onSearchQueryChange(it)
        },
        onSearch = {
            viewModel.onSearch()
        },
        onClear = {
            viewModel.onClearSearchQuery()
        },
        onFavorite = {
            viewModel.onFavoritePressed(it)
        },
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchQuery: String,
    searchResults: List<Word>,
    status: UiStatus = UiStatus.IDLE,
    onSearchQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onClear: () -> Unit,
    onFavorite: (Word) -> Unit,
) {
    var query by remember { mutableStateOf(searchQuery) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        TextField(
            value = searchQuery,
            onValueChange = {
                query = it
                onSearchQueryChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        modifier = Modifier.clickable {
                            onClear()
                        }
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                    onSearch()
                }
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 14.dp)
        )
        if (searchResults.isEmpty()) {
            EmptyState(
                title = "No words found"
            )
        } else if (status == UiStatus.LOADING) {
            LoadingIndicator()
        } else if (status == UiStatus.ERROR) {
            ErrorState(
                title = "Error",
                subtitle = "Something went wrong"
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(all = 14.dp)
            ) {
                items(
                    count = searchResults.size,
                    itemContent = { index ->
                        val word = searchResults[index]
                        WordListItem(
                            word = word,
                            onFavorite = onFavorite,
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun WordListItem(
    word: Word,
    onFavorite: (Word) -> Unit,
    modifier: Modifier = Modifier
) {

    val iconTint =
        if (word.favorite) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.secondary

    Card(
        modifier = modifier
            .padding(bottom = 8.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 14.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = word.word,
                    style = MaterialTheme.typography.headlineLarge
                )
                IconButton(
                    onClick = {
                        onFavorite(word)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorite Icon",
                        tint = iconTint,
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AudioPlayer(
                    audioUrl = word.phonetics[0].audio
                )
                Text(
                    text = word.phonetic,
                )
            }
            word.meanings.forEach {
                WordMeaningItem(meaning = it)
            }
        }
    }
}

@Composable
fun WordMeaningItem(
    modifier: Modifier = Modifier,
    meaning: Meaning
) {
    Column {
        // Add blank space
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = meaning.partOfSpeech,
            style = MaterialTheme.typography.titleMedium
        )
        Row {
            Text(text = "Meaning: ")
            Text(text = meaning.definitions[0].definition)
        }
        if (meaning.definitions[0].example != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Example: ")
            Text(text = meaning.definitions[0].example!!)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchionaryTheme {

        val searchQuery = "Hello"
        val searchResults = WordSample().wordSuccess

        SearchScreen(
            searchQuery = searchQuery,
            searchResults = searchResults,
            onSearchQueryChange = {},
            onSearch = {},
            onClear = {},
            onFavorite = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenEmptyStatePreview() {
    SearchionaryTheme {

        val searchQuery = "Hello"
        val searchResults = emptyList<Word>()

        SearchScreen(
            searchQuery = searchQuery,
            searchResults = searchResults,
            onSearchQueryChange = {},
            onSearch = {},
            onClear = {},
            onFavorite = {},
        )
    }
}


//SearchBar(
//query = searchQuery,
//active = active,
//onQueryChange = onSearchQueryChange,
//onSearch = {
//    onActiveChange(false)
//},
//onActiveChange = onActiveChange,
//placeholder = {
//    Text(text = "Search...")
//},

//modifier = modifier.fillMaxWidth()
//) {
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(32.dp),
//        contentPadding = PaddingValues(16.dp),
//        modifier = Modifier.fillMaxSize()
//    ) {
//        items(
//            count = searchResults.size,
//            key = { index -> searchResults[index].id },
//            itemContent = { index ->
//                val word = searchResults[index]
//                WordListItem(word = word)
//            }
//        )
//    }
//}
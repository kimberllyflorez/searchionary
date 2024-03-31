package com.bimblystudios.searchionary.presentation.search

import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimblystudios.searchionary.data.model.Word
import com.bimblystudios.searchionary.data.model.sample.WordSample
import com.bimblystudios.searchionary.data.remote.DictionaryEndpoints
import com.bimblystudios.searchionary.presentation.common.UiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class SearchViewModel(
    private val searchWordUseCase: DictionaryEndpoints
) : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            // TODO: Add necessary init logic here
        }
    }

    fun onSearchQueryChange(query: String) {
        _state.update {
            it.copy(searchQuery = query)
        }
    }

    fun onClearSearchQuery() {
        _state.update {
            it.copy(searchQuery = "", searchResults = emptyList())
        }
    }

    fun onSearch() {
        if (_state.value.searchQuery.isEmpty()) return
        viewModelScope.launch {
            _state.update {
                it.copy(status = UiStatus.LOADING)
            }
            viewModelScope.launch {
                // TODO: Commented for test purposes
//                val word = searchWordUseCase.searchWord(
//                    _state.value.searchQuery
//                )
                delay(500)
                val word = WordSample().wordSuccess
                _state.update {
                    it.copy(
                        searchResults = word,
                        status = UiStatus.SUCCESS
                    )
                }
            }

        }
    }

    fun onFavoritePressed(word: Word) {
        _state.update { state ->
            state.copy(
                searchResults = state.searchResults.map {
                    it.copy(favorite = it.word == word.word && !it.favorite)
                }
            )
        }
    }

    data class SearchState(
        val searchQuery: String = "",
        val searchResults: List<Word> = emptyList(),
        val status: UiStatus = UiStatus.IDLE
    )
}

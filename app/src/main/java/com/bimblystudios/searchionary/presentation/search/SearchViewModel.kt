package com.bimblystudios.searchionary.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimblystudios.searchionary.data.model.Word
import com.bimblystudios.searchionary.data.remote.DictionaryEndpoints
import com.bimblystudios.searchionary.domain.usecases.SearchWordUseCase
import com.bimblystudios.searchionary.presentation.common.UiStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchWordUseCase: SearchWordUseCase
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
                val word = searchWordUseCase.invoke(
                    _state.value.searchQuery
                )
//                 Uncomment to test response
                /*delay(500)
                val word = WordSample().wordSuccess*/
                if(word != null) {
                    _state.update {
                        it.copy(
                            searchResults = word,
                            status = UiStatus.SUCCESS
                        )
                    }
                } else {
                    _state.update {
                        it.copy(status = UiStatus.ERROR)
                    }
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

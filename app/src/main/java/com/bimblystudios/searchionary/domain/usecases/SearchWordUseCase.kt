package com.bimblystudios.searchionary.domain.usecases

import com.bimblystudios.searchionary.data.model.Word
import com.bimblystudios.searchionary.data.repositories.DictionaryRepository

 class SearchWordUseCase(  private val searchWordRepository: DictionaryRepository) {
    suspend operator fun  invoke(query: String): List<Word>? = searchWordRepository.searchWord(query)
}
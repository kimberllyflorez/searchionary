package com.bimblystudios.searchionary.data.repositories

import com.bimblystudios.searchionary.data.model.Word
import com.bimblystudios.searchionary.data.remote.DictionaryEndpointFactory

class DictionaryRepository (  private  val dictionaryEndpoint: DictionaryEndpointFactory){

suspend  fun  searchWord(word: String): List<Word>? {
    if (word.isEmpty())return  null
    val dictionaryResult = dictionaryEndpoint.retrofitService().searchWord(word)
    return  dictionaryResult
}
}
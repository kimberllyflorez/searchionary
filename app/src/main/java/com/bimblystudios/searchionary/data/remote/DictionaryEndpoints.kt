package com.bimblystudios.searchionary.data.remote

import com.bimblystudios.searchionary.data.model.Word
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryEndpoints {

    @GET("{word}")
    suspend fun searchWord(@Path("word") word: String): List<Word>
}
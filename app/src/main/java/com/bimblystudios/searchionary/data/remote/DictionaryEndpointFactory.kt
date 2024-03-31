
package com.bimblystudios.searchionary.data.remote


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DictionaryEndpointFactory {
    fun retrofitService(): DictionaryEndpoints{
        return Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/en/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DictionaryEndpoints::class.java)
    }


}
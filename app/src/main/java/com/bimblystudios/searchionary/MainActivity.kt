package com.bimblystudios.searchionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.bimblystudios.searchionary.data.remote.DictionaryEndpointFactory
import com.bimblystudios.searchionary.presentation.search.SearchScreen
import com.bimblystudios.searchionary.presentation.search.SearchViewModel
import com.bimblystudios.searchionary.presentation.ui.theme.SearchionaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // TODO: Add Dependency Injection
        val retrofitService = DictionaryEndpointFactory.retrofitService()

        setContent {
            SearchionaryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchScreen(
                        viewModel = SearchViewModel(
                            searchWordUseCase = retrofitService
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
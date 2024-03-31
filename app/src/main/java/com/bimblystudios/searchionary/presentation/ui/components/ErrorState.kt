package com.bimblystudios.searchionary.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bimblystudios.searchionary.presentation.ui.theme.SearchionaryTheme

@Composable
fun ErrorState(
    title: String? = null,
    subtitle: String? = null,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = title ?: "Sorry, something went wrong",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = subtitle ?: "Please try again later",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorStatePreview() {
    SearchionaryTheme {
        ErrorState()
    }
}
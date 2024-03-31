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
fun EmptyState(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = title ?: "No results",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = subtitle ?: "Try adjusting your search",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyStatePreview() {
    SearchionaryTheme {
        EmptyState()
    }
}
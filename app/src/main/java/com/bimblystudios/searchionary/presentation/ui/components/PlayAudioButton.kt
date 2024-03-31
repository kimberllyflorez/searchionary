package com.bimblystudios.searchionary.presentation.ui.components

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.bimblystudios.searchionary.presentation.ui.theme.SearchionaryTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

@Composable
fun AudioPlayer(audioUrl: String) {
    val mediaPlayer = remember { MediaPlayer() }
    val isPlaying = remember { mutableStateOf(false) }

    Column {
        IconButton(
            onClick = {
                if (!isPlaying.value) {
                    playAudio(mediaPlayer, audioUrl)
                } else {
                    stopAudio(mediaPlayer)
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Stop Phonetic Icon",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayAudioButtonPreview() {
    SearchionaryTheme {
        AudioPlayer(audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
    }
}

// TODO: Move to utils
private fun playAudio(mediaPlayer: MediaPlayer, audioUrl: String) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            mediaPlayer.apply {
                reset()
                setDataSource(audioUrl)
                prepare()
                start()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

private fun stopAudio(mediaPlayer: MediaPlayer) {
    mediaPlayer.apply {
        stop()
        reset()
    }
}